package com.example.atmapp.room.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.atmapp.model.ATMEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ATMDao_Impl implements ATMDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ATMEntity> __insertionAdapterOfATMEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAtmAmounts;

  public ATMDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfATMEntity = new EntityInsertionAdapter<ATMEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ATMEntity` (`id`,`atmTotalAmount`,`atm100NotesCount`,`atm200NotesCount`,`atm500NotesCount`,`atm2000NotesCount`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ATMEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getAtmTotalAmount());
        stmt.bindLong(3, value.getAtm100NotesCount());
        stmt.bindLong(4, value.getAtm200NotesCount());
        stmt.bindLong(5, value.getAtm500NotesCount());
        stmt.bindLong(6, value.getAtm2000NotesCount());
      }
    };
    this.__preparedStmtOfUpdateAtmAmounts = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE ATMEntity set atmTotalAmount=?,atm100NotesCount=?,atm200NotesCount=?,atm500NotesCount=?,atm2000NotesCount=? where  id=?";
        return _query;
      }
    };
  }

  @Override
  public Object insertATMEntry(final ATMEntity atm, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfATMEntity.insert(atm);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateAtmAmounts(final int id, final int balanceAmt, final int amount100Count,
      final int amount200Count, final int amount500Count, final int amount2000Count,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAtmAmounts.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, balanceAmt);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, amount100Count);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, amount200Count);
        _argIndex = 4;
        _stmt.bindLong(_argIndex, amount500Count);
        _argIndex = 5;
        _stmt.bindLong(_argIndex, amount2000Count);
        _argIndex = 6;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfUpdateAtmAmounts.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<ATMEntity>> getAtmAmounts() {
    final String _sql = "select * from ATMEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"ATMEntity"}, false, new Callable<List<ATMEntity>>() {
      @Override
      public List<ATMEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAtmTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "atmTotalAmount");
          final int _cursorIndexOfAtm100NotesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm100NotesCount");
          final int _cursorIndexOfAtm200NotesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm200NotesCount");
          final int _cursorIndexOfAtm500NotesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm500NotesCount");
          final int _cursorIndexOfAtm2000NotesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm2000NotesCount");
          final List<ATMEntity> _result = new ArrayList<ATMEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ATMEntity _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final int _tmpAtmTotalAmount;
            _tmpAtmTotalAmount = _cursor.getInt(_cursorIndexOfAtmTotalAmount);
            final int _tmpAtm100NotesCount;
            _tmpAtm100NotesCount = _cursor.getInt(_cursorIndexOfAtm100NotesCount);
            final int _tmpAtm200NotesCount;
            _tmpAtm200NotesCount = _cursor.getInt(_cursorIndexOfAtm200NotesCount);
            final int _tmpAtm500NotesCount;
            _tmpAtm500NotesCount = _cursor.getInt(_cursorIndexOfAtm500NotesCount);
            final int _tmpAtm2000NotesCount;
            _tmpAtm2000NotesCount = _cursor.getInt(_cursorIndexOfAtm2000NotesCount);
            _item = new ATMEntity(_tmpId,_tmpAtmTotalAmount,_tmpAtm100NotesCount,_tmpAtm200NotesCount,_tmpAtm500NotesCount,_tmpAtm2000NotesCount);
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
