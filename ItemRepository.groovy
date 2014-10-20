import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper

import java.math.RoundingMode

@Grab("h2")
//@Grab(group= 'com.h2database' , module= 'h2' , version= '1.3.160' )

import java.sql.ResultSet

class ItemRepository {
  @Autowired
  JdbcTemplate jdbc
	
  List<Item> findAll() {
    jdbc.query(
      "select id, name, cost, inventory from items order by name",
      new RowMapper<Item>() {
          Item mapRow(ResultSet rs, int rowNum) {
              new Item(id: rs.getLong(1),
                       name: rs.getString(2),
                       cost: rs.getBigDecimal(3).setScale(2, RoundingMode.CEILING),
                       inventory: rs.getInt(4)
                      )
          }
      }
    )
  }

  void save(Item item) {
    jdbc.update("insert into items (name, cost, inventory) values (?, ?, ?)",
      item.name, item.cost, item.inventory)
  }
}