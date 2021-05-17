import java.sql.*;
import java.util.ArrayList;

public class Main{


    public static void main(String[] args) throws SQLException {
        DbHelper helper = new DbHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "delete from city where id=?";
        try {
            connection = helper.dbConnection();
            System.out.println("Baglanti olustu");
            statement = connection.prepareStatement(query);
            statement.setInt(1, 4087);

            int result = statement.executeUpdate();

            System.out.println("Kayit Silindi!");


        } catch (SQLException e) {
            helper.showErrorMessage(e);
        } finally {
            connection.close();
        }
    }

    public static void selectData() throws SQLException {
        DbHelper helper = new DbHelper();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "select Code, Name, Continent, Region from country";
        try {
            connection = helper.dbConnection();
            System.out.println("Baglanti olustu");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            ArrayList<Country> countries = new ArrayList<>();

            while(resultSet.next()){
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region" )));
                /*
                System.out.print(resultSet.getString("Code") + " ");
                System.out.print(resultSet.getString("Name") + " ");
                System.out.print(resultSet.getString("Continent") + " ");
                System.out.print(resultSet.getString("Region") + " ");
                System.out.println();
                */
            }
            System.out.println(countries.size());
            System.out.println(countries.get(1).toString());
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        } finally {
            connection.close();
        }
    }

    public static void instertData() throws SQLException {
        DbHelper helper = new DbHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "insert into city (Name,CountryCode,District,Population) values(?, ? , ?, ?)";
        try {
            connection = helper.dbConnection();
            System.out.println("Baglanti olustu");
            statement = connection.prepareStatement(query);
            statement.setString(1, "Düzce 2");
            statement.setString(2, "TUR");
            statement.setString(3, "Turkey");
            statement.setInt(4, 50000);
            int result = statement.executeUpdate();

            System.out.println("Kayit eklendi!");


        } catch (SQLException e) {
            helper.showErrorMessage(e);
        } finally {
            connection.close();
        }
    }

    public static void updateData() throws SQLException{

            DbHelper helper = new DbHelper();
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            String query = "update city set population=?, district=? where id=?";
            try {
                connection = helper.dbConnection();
                System.out.println("Baglanti olustu");
                statement = connection.prepareStatement(query);
                statement.setInt(1, 100000);
                statement.setString(2, "Ankara");
                statement.setInt(3, 4087);

                int result = statement.executeUpdate();

                System.out.println("Kayit güncellendi!");


            } catch (SQLException e) {
                helper.showErrorMessage(e);
            } finally {
                connection.close();
            }
        }
    }

