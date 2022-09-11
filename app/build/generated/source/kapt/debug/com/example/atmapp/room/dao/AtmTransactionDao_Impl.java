package com.example.atmapp.room.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.atmapp.model.AtmTransactionHistory;
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
public final class AtmTransactionDao_Impl implements AtmTransactionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AtmTransactionHistory> __insertionAdapterOfAtmTransactionHistory;

  public AtmTransactionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAtmTransactionHistory = new EntityInsertionAdapter<AtmTransactionHistory>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `AtmTransactionHistoryTable` (`trans_id`,`atm_withdraw_amount`,`atm_100_notes_count`,`atm_200_notes_count`,`atm_500_notes_count`,`atm_2000_notes_count`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AtmTransactionHistory value) {
        if (value.getTransId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getTransId());
        }
        if (value.getAtmWithdrawAmount() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getAtmWithdrawAmount());
        }
        if (value.getAtm100NotesCount() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getAtm100NotesCount());
        }
        if (value.getAtm200NotesCount() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getAtm200NotesCount());
        }
        if (value.getAtm500NotesCount() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getAtm500NotesCount());
        }
        if (value.getAtm2000NotesCount() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getAtm2000NotesCount());
        }
      }
    };
  }

  @Override
  public Object insertTransactionData(final AtmTransactionHistory transaction,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAtmTransactionHistory.insert(transaction);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<AtmTransactionHistory>> getAllTransactionHistory() {
    final String _sql = "select * from AtmTransactionHistoryTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"AtmTransactionHistoryTable"}, false, new Callable<List<AtmTransactionHistory>>() {
      @Override
      public List<AtmTransactionHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransId = CursorUtil.getColumnIndexOrThrow(_cursor, "trans_id");
          final int _cursorIndexOfAtmWithdrawAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm_withdraw_amount");
          final int _cursorIndexOfAtm100NotesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm_100_notes_count");
          final int _cursorIndexOfAtm200NotesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm_200_notes_count");
          final int _cursorIndexOfAtm500NotesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm_500_notes_count");
          final int _cursorIndexOfAtm2000NotesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm_2000_notes_count");
          final List<AtmTransactionHistory> _result = new ArrayList<AtmTransactionHistory>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AtmTransactionHistory _item;
            final Integer _tmpTransId;
            if (_cursor.isNull(_cursorIndexOfTransId)) {
              _tmpTransId = null;
            } else {
              _tmpTransId = _cursor.getInt(_cursorIndexOfTransId);
            }
            final Integer _tmpAtmWithdrawAmount;
            if (_cursor.isNull(_cursorIndexOfAtmWithdrawAmount)) {
              _tmpAtmWithdrawAmount = null;
            } else {
              _tmpAtmWithdrawAmount = _cursor.getInt(_cursorIndexOfAtmWithdrawAmount);
            }
            final Integer _tmpAtm100NotesCount;
            if (_cursor.isNull(_cursorIndexOfAtm100NotesCount)) {
              _tmpAtm100NotesCount = null;
            } else {
              _tmpAtm100NotesCount = _cursor.getInt(_cursorIndexOfAtm100NotesCount);
            }
            final Integer _tmpAtm200NotesCount;
            if (_cursor.isNull(_cursorIndexOfAtm200NotesCount)) {
              _tmpAtm200NotesCount = null;
            } else {
              _tmpAtm200NotesCount = _cursor.getInt(_cursorIndexOfAtm200NotesCount);
            }
            final Integer _tmpAtm500NotesCount;
            if (_cursor.isNull(_cursorIndexOfAtm500NotesCount)) {
              _tmpAtm500NotesCount = null;
            } else {
              _tmpAtm500NotesCount = _cursor.getInt(_cursorIndexOfAtm500NotesCount);
            }
            final Integer _tmpAtm2000NotesCount;
            if (_cursor.isNull(_cursorIndexOfAtm2000NotesCount)) {
              _tmpAtm2000NotesCount = null;
            } else {
              _tmpAtm2000NotesCount = _cursor.getInt(_cursorIndexOfAtm2000NotesCount);
            }
            _item = new AtmTransactionHistory(_tmpTransId,_tmpAtmWithdrawAmount,_tmpAtm100NotesCount,_tmpAtm200NotesCount,_tmpAtm500NotesCount,_tmpAtm2000NotesCount);
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

  @Override
  public LiveData<List<AtmTransactionHistory>> getLastTransactionHistory() {
    final String _sql = "select * from AtmTransactionHistoryTable ORDER BY trans_id DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"AtmTransactionHistoryTable"}, false, new Callable<List<AtmTransactionHistory>>() {
      @Override
      public List<AtmTransactionHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransId = CursorUtil.getColumnIndexOrThrow(_cursor, "trans_id");
          final int _cursorIndexOfAtmWithdrawAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm_withdraw_amount");
          final int _cursorIndexOfAtm100NotesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm_100_notes_count");
          final int _cursorIndexOfAtm200NotesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm_200_notes_count");
          final int _cursorIndexOfAtm500NotesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm_500_notes_count");
          final int _cursorIndexOfAtm2000NotesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "atm_2000_notes_count");
          final List<AtmTransactionHistory> _result = new ArrayList<AtmTransactionHistory>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AtmTransactionHistory _item;
            final Integer _tmpTransId;
            if (_cursor.isNull(_cursorIndexOfTransId)) {
              _tmpTransId = null;
            } else {
              _tmpTransId = _cursor.getInt(_cursorIndexOfTransId);
            }
            final Integer _tmpAtmWithdrawAmount;
            if (_cursor.isNull(_cursorIndexOfAtmWithdrawAmount)) {
              _tmpAtmWithdrawAmount = null;
            } else {
              _tmpAtmWithdrawAmount = _cursor.getInt(_cursorIndexOfAtmWithdrawAmount);
            }
            final Integer _tmpAtm100NotesCount;
            if (_cursor.isNull(_cursorIndexOfAtm100NotesCount)) {
              _tmpAtm100NotesCount = null;
            } else {
              _tmpAtm100NotesCount = _cursor.getInt(_cursorIndexOfAtm100NotesCount);
            }
            final Integer _tmpAtm200NotesCount;
            if (_cursor.isNull(_cursorIndexOfAtm200NotesCount)) {
              _tmpAtm200NotesCount = null;
            } else {
              _tmpAtm200NotesCount = _cursor.getInt(_cursorIndexOfAtm200NotesCount);
            }
            final Integer _tmpAtm500NotesCount;
            if (_cursor.isNull(_cursorIndexOfAtm500NotesCount)) {
              _tmpAtm500NotesCount = null;
            } else {
              _tmpAtm500NotesCount = _cursor.getInt(_cursorIndexOfAtm500NotesCount);
            }
            final Integer _tmpAtm2000NotesCount;
            if (_cursor.isNull(_cursorIndexOfAtm2000NotesCount)) {
              _tmpAtm2000NotesCount = null;
            } else {
              _tmpAtm2000NotesCount = _cursor.getInt(_cursorIndexOfAtm2000NotesCount);
            }
            _item = new AtmTransactionHistory(_tmpTransId,_tmpAtmWithdrawAmount,_tmpAtm100NotesCount,_tmpAtm200NotesCount,_tmpAtm500NotesCount,_tmpAtm2000NotesCount);
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
