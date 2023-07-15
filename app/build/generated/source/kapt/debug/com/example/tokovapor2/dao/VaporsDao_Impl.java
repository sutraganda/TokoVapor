package com.example.tokovapor2.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.tokovapor2.model.Vapors;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class VaporsDao_Impl implements VaporsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Vapors> __insertionAdapterOfVapors;

  private final EntityDeletionOrUpdateAdapter<Vapors> __deletionAdapterOfVapors;

  private final EntityDeletionOrUpdateAdapter<Vapors> __updateAdapterOfVapors;

  public VaporsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVapors = new EntityInsertionAdapter<Vapors>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `vapors_table` (`id`,`name`,`address`,`goods`,`type`,`amountgoods`,`latitude`,`longitude`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Vapors value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAddress());
        }
        if (value.getGoods() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGoods());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getAmountgoods() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAmountgoods());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getLatitude());
        }
        if (value.getLongitude() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getLongitude());
        }
      }
    };
    this.__deletionAdapterOfVapors = new EntityDeletionOrUpdateAdapter<Vapors>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `vapors_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Vapors value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfVapors = new EntityDeletionOrUpdateAdapter<Vapors>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `vapors_table` SET `id` = ?,`name` = ?,`address` = ?,`goods` = ?,`type` = ?,`amountgoods` = ?,`latitude` = ?,`longitude` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Vapors value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAddress());
        }
        if (value.getGoods() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGoods());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getAmountgoods() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAmountgoods());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getLatitude());
        }
        if (value.getLongitude() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getLongitude());
        }
        stmt.bindLong(9, value.getId());
      }
    };
  }

  @Override
  public Object insertVapors(final Vapors vapors, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfVapors.insert(vapors);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteVapors(final Vapors vapors, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfVapors.handle(vapors);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateVapors(final Vapors vapors, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfVapors.handle(vapors);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Vapors>> getALLVapors() {
    final String _sql = "SELECT * FROM vapors_table ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"vapors_table"}, new Callable<List<Vapors>>() {
      @Override
      public List<Vapors> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfGoods = CursorUtil.getColumnIndexOrThrow(_cursor, "goods");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfAmountgoods = CursorUtil.getColumnIndexOrThrow(_cursor, "amountgoods");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final List<Vapors> _result = new ArrayList<Vapors>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Vapors _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpGoods;
            if (_cursor.isNull(_cursorIndexOfGoods)) {
              _tmpGoods = null;
            } else {
              _tmpGoods = _cursor.getString(_cursorIndexOfGoods);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpAmountgoods;
            if (_cursor.isNull(_cursorIndexOfAmountgoods)) {
              _tmpAmountgoods = null;
            } else {
              _tmpAmountgoods = _cursor.getString(_cursorIndexOfAmountgoods);
            }
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            final Double _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            }
            _item = new Vapors(_tmpId,_tmpName,_tmpAddress,_tmpGoods,_tmpType,_tmpAmountgoods,_tmpLatitude,_tmpLongitude);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
