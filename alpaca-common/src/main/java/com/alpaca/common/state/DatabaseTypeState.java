package com.alpaca.common.state;

/**
 * @Auther: song
 * @Date: 2018/11/7 09:45
 * @Description:
 * @Version:1.0.0
 */
public enum DatabaseTypeState {

    ORACLE_DB(1,"oracle.jdbc.driver.OracleDriver","图标"),


    GREENPLUM_DB(2,"com.pivotal.jdbc.GreenplumDriver","图标"),

    /**
     * Sybase ASE 数据库
     */
    SYBASE_ASE_DB ( 3,"com.sybase.jdbc.SybDrive",""),


    INFORMIX_DB( 4,"com.sybase.jdbc.SybDrive",""),

    MYSQL_DB( 5,"com.mysql.jdbc.Driver",""),

    SQL_SERVER_DB ( 6,"com.microsoft.jdbc.sqlserver.SQLServerDriver",""),

    DB2_DB ( 7,"com.ibm.db2.jdbc.app.DB2Driver",""),

    /**
     * postgreSql
     */
    POSTGRESQL_DB ( 8,"org.postgresql.Driver",""),


    /**
     * 达梦数据库(国产)，目前政府机关及部分使用较多
     */
    DM_DB ( 9,"dm.jdbc.driver.DmDriver",""),

    H2_DB( 10,"org.h2.Driver",""),

    HIVE_DB ( 11,"org.apache.hive.jdbc.HiveDriver",""),


    FTP( 21,"",""),

    HDFS_FILE ( 31,"",""),

    /**
     * hbase 数据库
     */
    HBASE_DB ( 32,"","");


    /**
     * 数据库类型
     */
   int type;
    /**
     * 驱动名
     */
   String driverName;

    /**
     * 图标
     */
   String icon;

    DatabaseTypeState(int type, String driverName, String icon) {
        this.type = type;
        this.driverName = driverName;
        this.icon = icon;
    }
}
