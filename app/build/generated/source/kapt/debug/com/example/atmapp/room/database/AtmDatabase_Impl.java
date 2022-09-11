package com.example.atmapp.room.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.atmapp.room.dao.ATMDao;
import com.example.atmapp.room.dao.ATMDao_Impl;
import com.example.atmapp.room.dao.AtmTransactionDao;
import com.example.atmapp.room.dao.AtmTransactionDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AtmDatabase_Impl extends AtmDatabase {
  private volatile ATMDao _aTMDao;

  private volatile AtmTransactionDao _atmTransactionDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ATMEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `atmTotalAmount` INTEGER NOT NULL, `atm100NotesCount` INTEGER NOT NULL, `atm200NotesCount` INTEGER NOT NULL, `atm500NotesCount` INTEGER NOT NULL, `atm2000NotesCount` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AtmTransactionHistoryTable` (`trans_id` INTEGER PRIMARY KEY AUTOINCREMENT, `atm_withdraw_amount` INTEGER, `atm_100_notes_count` INTEGER, `atm_200_notes_count` INTEGER, `atm_500_notes_count` INTEGER, `atm_2000_notes_count` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7190593ca8d2f186fdeeeae7f606a30c')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `ATMEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `AtmTransactionHistoryTable`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsATMEntity = new HashMap<String, TableInfo.Column>(6);
        _columnsATMEntity.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsATMEntity.put("atmTotalAmount", new TableInfo.Column("atmTotalAmount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsATMEntity.put("atm100NotesCount", new TableInfo.Column("atm100NotesCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsATMEntity.put("atm200NotesCount", new TableInfo.Column("atm200NotesCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsATMEntity.put("atm500NotesCount", new TableInfo.Column("atm500NotesCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsATMEntity.put("atm2000NotesCount", new TableInfo.Column("atm2000NotesCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysATMEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesATMEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoATMEntity = new TableInfo("ATMEntity", _columnsATMEntity, _foreignKeysATMEntity, _indicesATMEntity);
        final TableInfo _existingATMEntity = TableInfo.read(_db, "ATMEntity");
        if (! _infoATMEntity.equals(_existingATMEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "ATMEntity(com.example.atmapp.model.ATMEntity).\n"
                  + " Expected:\n" + _infoATMEntity + "\n"
                  + " Found:\n" + _existingATMEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsAtmTransactionHistoryTable = new HashMap<String, TableInfo.Column>(6);
        _columnsAtmTransactionHistoryTable.put("trans_id", new TableInfo.Column("trans_id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAtmTransactionHistoryTable.put("atm_withdraw_amount", new TableInfo.Column("atm_withdraw_amount", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAtmTransactionHistoryTable.put("atm_100_notes_count", new TableInfo.Column("atm_100_notes_count", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAtmTransactionHistoryTable.put("atm_200_notes_count", new TableInfo.Column("atm_200_notes_count", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAtmTransactionHistoryTable.put("atm_500_notes_count", new TableInfo.Column("atm_500_notes_count", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAtmTransactionHistoryTable.put("atm_2000_notes_count", new TableInfo.Column("atm_2000_notes_count", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAtmTransactionHistoryTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAtmTransactionHistoryTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAtmTransactionHistoryTable = new TableInfo("AtmTransactionHistoryTable", _columnsAtmTransactionHistoryTable, _foreignKeysAtmTransactionHistoryTable, _indicesAtmTransactionHistoryTable);
        final TableInfo _existingAtmTransactionHistoryTable = TableInfo.read(_db, "AtmTransactionHistoryTable");
        if (! _infoAtmTransactionHistoryTable.equals(_existingAtmTransactionHistoryTable)) {
          return new RoomOpenHelper.ValidationResult(false, "AtmTransactionHistoryTable(com.example.atmapp.model.AtmTransactionHistory).\n"
                  + " Expected:\n" + _infoAtmTransactionHistoryTable + "\n"
                  + " Found:\n" + _existingAtmTransactionHistoryTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "7190593ca8d2f186fdeeeae7f606a30c", "282ffa7bc39c1220e8e0c8cea1e9c363");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "ATMEntity","AtmTransactionHistoryTable");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `ATMEntity`");
      _db.execSQL("DELETE FROM `AtmTransactionHistoryTable`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ATMDao.class, ATMDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AtmTransactionDao.class, AtmTransactionDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public ATMDao getAtmDao() {
    if (_aTMDao != null) {
      return _aTMDao;
    } else {
      synchronized(this) {
        if(_aTMDao == null) {
          _aTMDao = new ATMDao_Impl(this);
        }
        return _aTMDao;
      }
    }
  }

  @Override
  public AtmTransactionDao getAtmTransactionDao() {
    if (_atmTransactionDao != null) {
      return _atmTransactionDao;
    } else {
      synchronized(this) {
        if(_atmTransactionDao == null) {
          _atmTransactionDao = new AtmTransactionDao_Impl(this);
        }
        return _atmTransactionDao;
      }
    }
  }
}
