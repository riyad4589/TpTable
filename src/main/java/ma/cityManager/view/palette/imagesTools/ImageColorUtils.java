package ma.cityManager.view.palette.imagesTools;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageColorUtils {

    /**
     * Applique une teinte sur une ImageIcon en modifiant les composantes RGB
     * @param icon l'icône d'origine
     * @param redFactor facteur multiplicatif pour le rouge   (ex: 1.0 = inchangé)
     * @param greenFactor facteur multiplicatif pour le vert  (ex: 0.8 = un peu plus sombre)
     * @param blueFactor facteur multiplicatif pour le bleu   (ex: 1.2 = plus clair)
     * @return une nouvelle ImageIcon avec la couleur modifiée
     */
    public static ImageIcon tintImageIcon(ImageIcon icon, double redFactor, double greenFactor, double blueFactor) {
        if (icon == null) return null;

        // Convertir l'image de l'icône en BufferedImage
        Image img = icon.getImage();
        BufferedImage buffered = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffered.createGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose();

        // Parcourir les pixels et appliquer les facteurs
        for (int y = 0; y < buffered.getHeight(); y++) {
            for (int x = 0; x < buffered.getWidth(); x++) {
                int argb = buffered.getRGB(x, y);
                Color c = new Color(argb, true);
                int r = clamp((int) (c.getRed()   * redFactor));
                int g = clamp((int) (c.getGreen() * greenFactor));
                int b = clamp((int) (c.getBlue()  * blueFactor));
                int a = c.getAlpha();
                int newColor = (a << 24) | (r << 16) | (g << 8) | b;
                buffered.setRGB(x, y, newColor);
            }
        }

        return new ImageIcon(buffered);
    }

    public static ImageIcon applyColorOverlay(ImageIcon icon, Color tintColor, float alpha) {
        if (icon == null) return null;

        // Convertir l'image en BufferedImage
        Image img = icon.getImage();
        BufferedImage buffered = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffered.createGraphics();
        g2.drawImage(img, 0, 0, null);

        // Appliquer une couche de couleur semi-transparente
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        g2.setColor(tintColor);
        g2.fillRect(0, 0, buffered.getWidth(), buffered.getHeight());
        g2.dispose();

        return new ImageIcon(buffered);
    }

    // Méthode utilitaire pour s'assurer que les valeurs RGB restent entre 0 et 255
    private static int clamp(int val) {
        return Math.max(0, Math.min(255, val));
    }


}
