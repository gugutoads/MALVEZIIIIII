package view;

import model.Conta; // Importando a classe Conta
import utils.DataManager; // Importando a classe DataManager
import java.util.List; // Importando a interface List
import java.util.ArrayList; // Importando a classe ArrayList
import javax.swing.*;
import java.awt.*;

public class FormularioAbrirConta extends JFrame {
    private JTextField tfNumeroConta;
    private JTextField tfNome;
    private JTextField tfCpf;
    private JComboBox<String> cbTipoConta;

    public FormularioAbrirConta() {
        setTitle("Abrir Conta");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel lblNumeroConta = new JLabel("Número da Conta:");
        tfNumeroConta = new JTextField();
        JLabel lblNome = new JLabel("Nome:");
        tfNome = new JTextField();
        JLabel lblCpf = new JLabel("CPF:");
        tfCpf = new JTextField();
        JLabel lblTipoConta = new JLabel("Tipo de Conta:");
        cbTipoConta = new JComboBox<>(new String[] { "Corrente", "Poupança" });
        JButton btnCriarConta = new JButton("Criar Conta");

        panel.add(lblNumeroConta);
        panel.add(tfNumeroConta);
        panel.add(lblNome);
        panel.add(tfNome);
        panel.add(lblCpf);
        panel.add(tfCpf);
        panel.add(lblTipoConta);
        panel.add(cbTipoConta);
        panel.add(new JLabel()); // Espaço vazio
        panel.add(btnCriarConta);

        add(panel);

        // Ação para criar a conta
        btnCriarConta.addActionListener(e -> criarConta());

        setVisible(true);
    }

    private void criarConta() {
        String numeroConta = tfNumeroConta.getText();
        String nome = tfNome.getText();
        String cpf = tfCpf.getText();
        String tipoConta = (String) cbTipoConta.getSelectedItem();

        // Criar a conta
        Conta novaConta = new Conta(numeroConta, nome, cpf, tipoConta);

        // Carregar as contas existentes
        List<Conta> contas = DataManager.carregarContas("contas.dat");

        // Adicionar a nova conta à lista
        contas.add(novaConta);

        // Salvar as contas (incluindo a nova conta) no arquivo
        DataManager.salvarContas(contas, "contas.dat");

        // Exibir mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Conta criada com sucesso!\nNúmero da Conta: " + numeroConta + "\nNome: " + nome + "\nTipo de Conta: " + tipoConta);

        // Fechar o formulário
        dispose();
    }
}

