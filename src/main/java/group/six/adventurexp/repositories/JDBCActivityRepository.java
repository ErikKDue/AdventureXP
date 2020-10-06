package group.six.adventurexp.repositories;

import group.six.adventurexp.models.Activity;
import group.six.adventurexp.models.DBManager;
import group.six.adventurexp.repositories.interfaces.IActivityRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/*
* Properties of activity
* activity_id (auto-increment)
* name
* price
* description
* restriction
* */
public class JDBCActivityRepository implements IActivityRepository {

    @Override
    public boolean create(Activity newItem)/*throws SQLException*/{
        int rowsAffected =0;
        try {
            Connection connection = DBManager.getConnection();
            //String sql = "INSERT INTO activity values( ?, ?, ?, ?)";
            String sql = "INSERT INTO activity (name, price, description, restriction) values( ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newItem.getName());
            statement.setDouble(2, newItem.getPrice());
            statement.setString(3, newItem.getDescription());
            statement.setString(4, newItem.getRestriction());
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            if(e instanceof SQLIntegrityConstraintViolationException){
                //throw new DepartmentException("Department not added");
            }
        }
        return (rowsAffected==1);
    }

    @Override
    public Activity read(int ID) {

        try {
            Connection connection = DBManager.getConnection();
            String sql = "SELECT * FROM activity WHERE activity_id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ID);

            ResultSet rs = statement.executeQuery();

            if (rs.next()){ //skal være i rigtig rækkefølge?
                int id = rs.getInt("activity_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String restriction = rs.getString("restriction");
                return new Activity(id, name, price, description, restriction);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Activity readByName(String inpName) {

        try {
            Connection connection = DBManager.getConnection();
            String sql = "SELECT * FROM activity WHERE name =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, inpName);

            ResultSet rs = statement.executeQuery();

            if (rs.next()){ //skal være i rigtig rækkefølge?
                int id = rs.getInt("activity_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String restriction = rs.getString("restriction");
                return new Activity(id, name, price, description, restriction);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Activity> readAll(){
        ArrayList<Activity> activities = new ArrayList<Activity>();
        try {
            Connection connection = DBManager.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM activity"; // NATURAL JOIN dept";
            ResultSet rs = statement.executeQuery(sql); //rammer jeg stålet på databasen
            int id;
            String name;
            double price;
            String description;
            String restriction;

            //Department dept;

            //Employee emp = new Employee();
            while (rs.next()) {
                /*empno = rs.getInt("empno");
                eName = rs.getString("ename");
                job = rs.getString("job");
                hireDate = rs.getDate("hiredate").toLocalDate();
                sal = rs.getInt("sal");*/
                id = rs.getInt("activity_id");
                name = rs.getString("name");
                price = rs.getDouble("price");
                description = rs.getString("description");
                restriction = rs.getString("restriction");

                //Employee emp = new Employee(empno, eName, job, hireDate, sal);//kan man spare ved at bruge getters og setter i stedet?

                // dept = dm.load(rs);
                Activity act = new Activity(id, name, price, description, restriction);
                activities.add(act);
                //System.out.println(empno);
                //System.out.println(emp.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;
    }

    @Override
    public boolean update(Activity item) {
        //"UPDATE student SET firstname=?, lastname=?, startdate=? WHERE studentid=?";
        //"UPDATE activity SET name=?, price=?, description=?, restriction=? WHERE studentid=?"
        int rowsAffected =0;
        try {
            Connection connection = DBManager.getConnection();
            String sql = "UPDATE activity SET name=?, price=?, description=?, restriction=? WHERE activity_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setString(3, item.getDescription());
            statement.setString(4, item.getRestriction());
            statement.setInt(5, item.getId());
            rowsAffected = statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //read by item.id
        //replace the activity found there with item
        return (rowsAffected==1);
    }

    @Override
    public boolean delete(int id) {
        //delete where ID matches ID lol
        int rowsAffected =0;
        try {
            Connection connection = DBManager.getConnection();
            String sql = "DELETE FROM activity WHERE activity_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            rowsAffected = statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (rowsAffected==1);
    }
}
