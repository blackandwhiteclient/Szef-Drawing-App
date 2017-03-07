/*******************************************************************************
 *     Szef Paint App
 *     Copyright (C) 2017  MartonDev
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package tk.szef.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
 
import javax.swing.JComponent;
 
public class DrawArea extends JComponent {
 

  private Image image;
 
  private Graphics2D g2;

  private int currentX, currentY, oldX, oldY;
 
  public DrawArea() {
    setDoubleBuffered(false);
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {

        oldX = e.getX();
        oldY = e.getY();
      }
    });
 
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
 
        currentX = e.getX();
        currentY = e.getY();
 
        if (g2 != null) {

          g2.drawLine(oldX, oldY, currentX, currentY);
      
          repaint();
    
          oldX = currentX;
          oldY = currentY;
        }
      }
    });
  }
 
  protected void paintComponent(Graphics g) {
    if (image == null) {

      image = createImage(getSize().width, getSize().height);
      g2 = (Graphics2D) image.getGraphics();

      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      clear();
    }
 
    g.drawImage(image, 0, 0, null);
  }
 
  public void clear() {
    g2.setPaint(Color.white);
 
    g2.fillRect(0, 0, getSize().width, getSize().height);
    g2.setPaint(Color.black);
    repaint();
  }
 
  public void red() {

    g2.setPaint(Color.red);
  }
 
  public void black() {
    g2.setPaint(Color.black);
  }
 
  public void magenta() {
    g2.setPaint(Color.magenta);
  }
 
  public void green() {
    g2.setPaint(Color.green);
  }
 
  public void blue() {
    g2.setPaint(Color.blue);
  }

}
