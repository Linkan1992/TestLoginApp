package a740362.testloginapp.data.entity.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_table")
data class TestTable(

        @ColumnInfo(name = "column1")
        var col1: String,

        @ColumnInfo(name = "column2")
        var col2: String,

        @ColumnInfo(name = "column3")
        var col3: String,

        @ColumnInfo(name = "column4")
        var col4: String

) {

    // way to generate primary key
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "test_id")
    var row_id: Int = 0


}
