import com.masolar.gui.ProgramFrame;

/**
 * Created by Masolar on 5/12/2017.
 *
 * This class is used to setup and launch the program.
 */
public class ProgramLaunch {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(ProgramFrame::new);
    }
}
