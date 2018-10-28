import java.io.IOException;

public class Driver
{

    public static void main(String[] args) throws IOException
    {
        // TODO Auto-generated method stub
        final int YEAR = 2018;
        final int MONTH = 8;
        final int DAY = 1;
        final int HOUR = 7;
        final int MINUTE = 00;
        final String directory = "data";

        MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);

        mapData.parseFile();

        System.out.println(mapData);

    }

}
