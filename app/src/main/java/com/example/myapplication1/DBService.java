package com.example.myapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;


public class DBService {
//    DBHelper dbHelper= new DBHelper(null,null,null,1);
    //新增
    public void insert(Context context, String tablename, ContentValues value){
        DBHelper dbHelper= new DBHelper(context,"testdb",null,2);
        // 通过DBHelper类获取一个读写的SQLiteDatabase对象
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        // 创建ContentValue设置参数
//        ContentValues contentValues=new ContentValues();
//        contentValues.put("name",name);
//        contentValues.put("password",password);
//        contentValues.put("ifman",man);
//        contentValues.put("ifwoman",woman);
//        contentValues.put("image", image);
        // 插入数据
        // insert方法参数1：要插入的表名
        // insert方法参数2：如果发现将要插入的行为空时，会将这个列名的值设为null
        // insert方法参数3：contentValue
        db.insert(tablename,null ,value);

        // 释放连接
        db.close();
    }
    //删除
//    public void delete(long id) {
//        DBHelper dbHelper= new DBHelper(context,"testdb",null,1);
//        // 通过DBHelper类获取一个读写的SQLiteDatabase对象
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        // 参数1：tablename
//        // 参数2：删除的条件（SQL语句）
//        // 参数3：给修改的条件注入参数，一个或多个
//        db.delete("user", "u_id=?", new String[]{id + ""});
//        // 释放连接
//        db.close();
//    }
//    //修改
    public void update(Context context, String tablename, String username, ContentValues value){
        DBHelper dbHelper= new DBHelper(context,"testdb",null,2);
        // 通过DBHelper类获取一个读写的SQLiteDatabase对象
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        // 创建ContentValue设置参数
//        ContentValues contentValues=new ContentValues();
//        contentValues.put("image",image);
        // 修改数据
        // 参数1：tablename
        // 参数2：修改的值
        // 参数3：修改的条件（SQL where语句）
        // 参数4：表示whereClause语句中的表达式的占位符参数列表，这些字符串会替换where条件中?
        db.update(tablename,value,"u_id=?",new String[]{username});

        // 释放连接
        db.close();
    }
    //查询
    public List<ContentValues> query(Context context, String tablename, String[] column, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String groupBy, @Nullable String having, @Nullable String orderBy) {
        DBHelper dbHelper= new DBHelper(context,"testdb",null,2);
        // 通过DBHelper类获取一个读写的SQLiteDatabase对象
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        // 参数1：table_name
        // 参数2：columns 要查询出来的列名。相当于 select  *** from table语句中的 ***部分
        // 参数3：selection 查询条件字句，在条件子句允许使用占位符“?”表示条件值
        // 参数4：selectionArgs ：对应于 selection参数 占位符的值
        // 参数5：groupby 相当于 select *** from table where && group by ... 语句中 ... 的部分
        // 参数6：having 相当于 select *** from table where && group by ...having %%% 语句中 %%% 的部分
        // 参数7：orderBy ：相当于 select  ***from ？？  where&& group by ...having %%% order by@@语句中的@@ 部分，如： personid desc（按person 降序）
        Cursor cursor;
        if(selection == null)
            cursor = db.query(tablename, column, selection, selectionArgs, groupBy, having, orderBy);
        else
            cursor = db.query(tablename, column, selection+"=?", selectionArgs, groupBy, having, orderBy);

        // 将游标移到开头
        cursor.moveToFirst();

        List<ContentValues> res = new ArrayList<>();
        while (!cursor.isAfterLast()) { // 游标只要不是在最后一行之后，就一直循环

//            int id=cursor.getInt(0);
//            String name=cursor.getString(1);
            ContentValues temp = new ContentValues();
            String[] tmpArr;
            if(column == null){
                if(tablename.equals("user"))
                    tmpArr = new String[]{"u_id", "psd", "gender", "avatar"};
                else
                    tmpArr = new String[]{"r_id", "u_id_1", "u_id_2"};
            }
            else {
                tmpArr = column;
            }
            for(String element: tmpArr){
                if(element.equals("psd") || element.equals("u_id") || element.equals("avatar"))
                    temp.put(element, cursor.getString(cursor.getColumnIndexOrThrow(element)));
                else if (element.equals("gender"))
                    temp.put(element, cursor.getInt(cursor.getColumnIndexOrThrow((element))));
            }
            res.add(temp);

            // 将游标移到下一行
            cursor.moveToNext();
        }
        db.close();
        return res;
    }

    public boolean isExist(Context context, String tablename, String selection, String[] selectionArgs){
        DBHelper dbHelper= new DBHelper(context,"testdb",null,2);
        // 通过DBHelper类获取一个读写的SQLiteDatabase对象
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(tablename, null, selection+"=?", selectionArgs, null, null, null);

        cursor.moveToFirst();
        boolean result = cursor.moveToNext();
        db.close();
        return result;
    }

    public void delete(Context context){
        DBHelper dbHelper= new DBHelper(context,"testdb",null,2);
        // 通过DBHelper类获取一个读写的SQLiteDatabase对象
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.execSQL("drop table user");
        db.execSQL("drop table ralation");
        db.close();
    }

}
