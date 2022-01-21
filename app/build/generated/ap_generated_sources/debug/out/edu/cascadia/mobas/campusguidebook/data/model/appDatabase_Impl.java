package edu.cascadia.mobas.campusguidebook.data.model;

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
import edu.cascadia.mobas.campusguidebook.ClubDao;
import edu.cascadia.mobas.campusguidebook.ClubDao_Impl;
import edu.cascadia.mobas.campusguidebook.EventDao;
import edu.cascadia.mobas.campusguidebook.EventDao_Impl;
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
public final class appDatabase_Impl extends appDatabase {
  private volatile EventDao _eventDao;

  private volatile ClubDao _clubDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Event_Table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `EventName` TEXT, `Description` TEXT, `Location` TEXT, `DateTime` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Club_Table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ClubName` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9119a00949e35f4845a37632ada1b285')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Event_Table`");
        _db.execSQL("DROP TABLE IF EXISTS `Club_Table`");
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
        final HashMap<String, TableInfo.Column> _columnsEventTable = new HashMap<String, TableInfo.Column>(5);
        _columnsEventTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEventTable.put("EventName", new TableInfo.Column("EventName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEventTable.put("Description", new TableInfo.Column("Description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEventTable.put("Location", new TableInfo.Column("Location", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEventTable.put("DateTime", new TableInfo.Column("DateTime", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEventTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEventTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEventTable = new TableInfo("Event_Table", _columnsEventTable, _foreignKeysEventTable, _indicesEventTable);
        final TableInfo _existingEventTable = TableInfo.read(_db, "Event_Table");
        if (! _infoEventTable.equals(_existingEventTable)) {
          return new RoomOpenHelper.ValidationResult(false, "Event_Table(edu.cascadia.mobas.campusguidebook.data.model.EventModel).\n"
                  + " Expected:\n" + _infoEventTable + "\n"
                  + " Found:\n" + _existingEventTable);
        }
        final HashMap<String, TableInfo.Column> _columnsClubTable = new HashMap<String, TableInfo.Column>(2);
        _columnsClubTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClubTable.put("ClubName", new TableInfo.Column("ClubName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClubTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClubTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClubTable = new TableInfo("Club_Table", _columnsClubTable, _foreignKeysClubTable, _indicesClubTable);
        final TableInfo _existingClubTable = TableInfo.read(_db, "Club_Table");
        if (! _infoClubTable.equals(_existingClubTable)) {
          return new RoomOpenHelper.ValidationResult(false, "Club_Table(edu.cascadia.mobas.campusguidebook.data.model.ClubModel).\n"
                  + " Expected:\n" + _infoClubTable + "\n"
                  + " Found:\n" + _existingClubTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "9119a00949e35f4845a37632ada1b285", "ca7c8dce9539773baf9fe9dbbd0faf14");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Event_Table","Club_Table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Event_Table`");
      _db.execSQL("DELETE FROM `Club_Table`");
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
    _typeConvertersMap.put(EventDao.class, EventDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ClubDao.class, ClubDao_Impl.getRequiredConverters());
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
  public EventDao EventDao() {
    if (_eventDao != null) {
      return _eventDao;
    } else {
      synchronized(this) {
        if(_eventDao == null) {
          _eventDao = new EventDao_Impl(this);
        }
        return _eventDao;
      }
    }
  }

  @Override
  public ClubDao ClubDao() {
    if (_clubDao != null) {
      return _clubDao;
    } else {
      synchronized(this) {
        if(_clubDao == null) {
          _clubDao = new ClubDao_Impl(this);
        }
        return _clubDao;
      }
    }
  }
}
