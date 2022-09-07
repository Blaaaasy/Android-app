package com.example.myapplication1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DBService {
    DBHelper dbHelper= new DBHelper(null,null,null,1);
    //新增
    public void insert(String name,String password, String man,String woman, Byte image){
        // 通过DBHelper类获取一个读写的SQLiteDatabase对象
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        // 创建ContentValue设置参数
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("password",password);
        contentValues.put("ifman",man);
        contentValues.put("ifwoman",woman);
        contentValues.put("image", image);
        // 插入数据
        // insert方法参数1：要插入的表名
        // insert方法参数2：如果发现将要插入的行为空时，会将这个列名的值设为null
        // insert方法参数3：contentValue
        long i=db.insert("user",null ,contentValues);

        // 释放连接
        db.close();
    }
    //删除
    public void delete(long id) {
        // 通过DBHelper类获取一个读写的SQLiteDatabase对象
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // 参数1：tablename
        // 参数2：删除的条件（SQL语句）
        // 参数3：给修改的条件注入参数，一个或多个
        db.delete("user", "u_id=?", new String[]{id + ""});
        // 释放连接
        db.close();
    }
    //修改
    public void update(String name,String password, String man,String woman, Byte image){
        // 通过DBHelper类获取一个读写的SQLiteDatabase对象
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        // 创建ContentValue设置参数
        ContentValues contentValues=new ContentValues();
        contentValues.put("image",image);
        // 修改数据
        // 参数1：tablename
        // 参数2：修改的值
        // 参数3：修改的条件（SQL where语句）
        // 参数4：表示whereClause语句中的表达式的占位符参数列表，这些字符串会替换where条件中?
        db.update("user",contentValues,"name=?",new String[]{name});

        // 释放连接
        db.close();
    }
    //查询
    public void query() {
        // 通过DBHelper类获取一个读写的SQLiteDatabase对象
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // 参数1：table_name
        // 参数2：columns 要查询出来的列名。相当于 select  *** from table语句中的 ***部分
        // 参数3：selection 查询条件字句，在条件子句允许使用占位符“?”表示条件值
        // 参数4：selectionArgs ：对应于 selection参数 占位符的值
        // 参数5：groupby 相当于 select *** from table where && group by ... 语句中 ... 的部分
        // 参数6：having 相当于 select *** from table where && group by ...having %%% 语句中 %%% 的部分
        // 参数7：orderBy ：相当于 select  ***from ？？  where&& group by ...having %%% order by@@语句中的@@ 部分，如： personid desc（按person 降序）
        Cursor cursor = db.query("user", null, null, null, null, null, null);

        // 将游标移到开头
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) { // 游标只要不是在最后一行之后，就一直循环

            int id=cursor.getInt(0);
            String name=cursor.getString(1);

            // 将游标移到下一行
            cursor.moveToNext();
        }
        db.close();
    }

}
