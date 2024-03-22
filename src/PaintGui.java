import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintGui extends JFrame {
    public PaintGui() {
        super("PaintGUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 650));
        pack();
        setLocationRelativeTo(null);

        addGuiComponents();
    }

    private void addGuiComponents() {
        // configuracoes JPanel
        JPanel canvasPanel = new JPanel();
        SpringLayout springLayout = new SpringLayout();
        canvasPanel.setLayout(springLayout);

        // 1. Canvas
        Canvas canvas = new Canvas(1000, 630);
        canvasPanel.add(canvas);
        springLayout.putConstraint(SpringLayout.NORTH, canvas, 50, SpringLayout.NORTH, canvasPanel);

        // 2. Seletor de cores
        JButton escolherCor = new JButton("Escolher cor");
        escolherCor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(null, "selecionar cores", Color.BLACK);
                escolherCor.setBackground(c);
                canvas.setColor(c);
            }
        });
        canvasPanel.add(escolherCor);
        springLayout.putConstraint(SpringLayout.NORTH, escolherCor, 10, SpringLayout.NORTH, canvasPanel);
        springLayout.putConstraint(SpringLayout.WEST, escolherCor, 25, SpringLayout.WEST, canvasPanel);

        // botao reset
        JButton botaoReset = new JButton("Resetar");
        botaoReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.resetCanvas();
            }
        });
        canvasPanel.add(botaoReset);
        springLayout.putConstraint(SpringLayout.NORTH, botaoReset, 10, SpringLayout.NORTH, canvasPanel);
        springLayout.putConstraint(SpringLayout.WEST, botaoReset, 150, SpringLayout.WEST, canvasPanel);

        this.getContentPane().add(canvasPanel);
    };
}

