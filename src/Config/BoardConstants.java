package Config;
/**
 * Created by zalmangagerman on 10/8/17.
 */
public class BoardConstants {
    final public static int MAX_TEAM_SIZE = 6;
    final public static int MIN_TEAM_SIZE = 3;
    final public static int MAX_PLAYERS = MAX_TEAM_SIZE * 2;
    final public static int MIN_PLAYERS = MIN_TEAM_SIZE * 2;
    final public static int ROW_SIZE = 7;
    final public static int COL_SIZE = 10;
    public enum TeamColor {RED, BLUE}
    final public static int BLUE_IND = 0;
    final public static int RED_IND = 1;
    final public static int INITIAL_ROW = 0;
    final public static int INITIAL_COLUMN = 0;
    final public static int DIE_SIZE = 6;

    public final static boolean[][] spEvSpaces = new boolean[][]
            {       {false, false, true, false, false, true, false},

                    {false, true, false, false, false, false, false},

                    {false, false, false, false, false, false, false},

                    {false, false, true, true, false, false, false},

                    {false, false, false, false, false, false, true},

                    {false, true, false, false, false, false, false},

                    {false, false, true, false, false, false, false},

                    {false, false, false, true, false, false, false},

                    {true, false, false, false, true, false, false},

                    {true, false, false, true, true, false, true}, };
}
