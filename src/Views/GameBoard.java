package Views;

import Controllers.TileController;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Config.BoardConstants.TeamColor.BLUE;
import static Config.BoardConstants.TeamColor.RED;

public class GameBoard {

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] tilePanels_;
    private JPanel raceBoard_;
    private JPanel boardPanel;
    private final JLabel message = new JLabel(
            "Let's Agile RACE!");
    private static final String[] COL_LABELS = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday ", "Thursday", "Friday", "Saturday" };
    private Image[] pieces_; // todo should be final

    GameBoard(int rows, int columns) {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        tilePanels_ =  new JButton[rows][columns];

        // Tool buttons on top
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("New")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(new JButton("Resign")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(message);
        //
        gui.add(new JLabel("?"), BorderLayout.LINE_START);

        raceBoard_ = new JPanel(new GridLayout(rows, columns)) {

            /**
             * Override the preferred size to return the largest it can, in
             * a square shape.  Must (must, must) be added to a GridBagLayout
             * as the only component (it uses the parent as a guide to size)
             * with no GridBagConstaint (so it is centered).
             */
            @Override
            public final Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension(
                            (int)d.getWidth(),(int)d.getHeight());
                } else if (c!=null &&
                        c.getWidth()>d.getWidth() &&
                        c.getHeight()>d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // the smaller of the two sizes
                int s = (w>h ? h : w);
                return new Dimension(s,s);
            }
        };
        raceBoard_.setBorder(new CompoundBorder(
                new EmptyBorder(8,8,8,8),
                new LineBorder(Color.BLACK)
        ));
        raceBoard_.setBorder(new LineBorder(Color.BLACK));

        //label the columns
        raceBoard_.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < COL_LABELS.length; ii++) {
            raceBoard_.add(
                    new JLabel(COL_LABELS[ii],
                            SwingConstants.CENTER));
        }



        // create the agile board tiles
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //transparent buttons
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                b.setOpaque(false);
                b.setContentAreaFilled(false);
                b.setBorderPainted(false);
                tilePanels_[j][i] = b;
            }
        }
        // load the tiles into raceboard
        for (int i = 0; i < tilePanels_.length; i++) {
            for (int j = 0; j < tilePanels_[i].length; j++) {
                raceBoard_.add(tilePanels_[i][j]);
            }
        }
        //todo - images of pieces at start space
        pieces_ = new Image[] {null, null};
        // todo

        gui.add(raceBoard_);

        // for tile designer: how to add icons (unsure of how to do with multiple pieces
        //tilePanels_[ii][0].setIcon(new ImageIcon(
        //      tilePanels_[0][STARTING_ROW[ii]]));
        // or something like that -- your call
    }

    public final JComponent getRaceBoard() {
        return raceBoard_;
    }

    public final JComponent getGui() {
        return gui;
    }

    public final void setPieces(java.util.List<TileController> tiles) {
        //todo
        int redCount = 0;
        int blueCount = 0;
        for (TileController tile : tiles) {
            redCount += tile.getNumberByTeam(RED);
            blueCount += tile.getNumberByTeam(BLUE);
        }
        //..where to go from here
        // todo
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
//                GameBoard cb =
//                        new GameBoard(ROW_SIZE, COL_SIZE);

                JFrame f = new JFrame("Let's place the Great Agile Race!");
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("/The-Great-Agile-Race/src/Views/Images/board.png"));
                    System.out.println("image found");
                } catch (IOException e) {
                    System.out.println("No image found");
                }

                BackgroundPanel t = new BackgroundPanel(img);
                t.setTransparentAdd(false);
                f.setContentPane(t);
                //f.add(cb.getGui());

                f.setResizable(false);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);


                //frame.setContentPane(new GameBoard().boardPanel);
                //Disabling ability to resize the form

            }
        };
        SwingUtilities.invokeLater(r);
    }
}