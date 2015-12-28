package Calendar;

/**
 * Created by Admin on 06.12.15.
 */
    import java.awt.Color;
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import java.awt.RenderingHints;
    import java.util.ArrayList;

    import javax.swing.JPanel;

    public class PieChart extends JPanel {

        private ArrayList<Double> values;
        private ArrayList<Color> colors;


        public PieChart(ArrayList values, ArrayList colors) {

            this.values = values;
            this.colors = colors;
        }


        @Override
        protected void paintComponent(Graphics g) {

            int width = getSize().width;

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

                int lastPoint = -270;
            double totalVal= 0;
            for(int i=0; i< values.size(); i++)
            {
                totalVal+=values.get(i);
            }
                for (int i = 0; i < values.size(); i++) {
                    g2d.setColor(colors.get(i));

                    Double val = values.get(i);
                    Double angle = val * 360 / totalVal;

                    g2d.fillArc(0, 0, width, width, lastPoint, -angle.intValue());
                    lastPoint = lastPoint + -angle.intValue();
                }

        }
    }


