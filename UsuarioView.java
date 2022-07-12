package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UsuarioView {	
	
	public class Login{
		public String Email;
		public String Senha;
	}
	
	public String definirTipoUsuario() {
		String[] escolhas = { "Cliente", "Restaurante" };
	    String entrada = (String) JOptionPane.showInputDialog(null, "Tipo de Usuário...",
	        "TIPO DE USUÁRIO", JOptionPane.QUESTION_MESSAGE, null, escolhas, escolhas[0]);	    
	    return entrada;
	}
	
	public JPanel MensagemErro(JPanel painel, String mensagem) {		
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));	
		JLabel erro = new JLabel(mensagem);	
		painel.add(erro);
		return painel;		
	}
	
	public String QuestionString(String message) {
		var opcaoSelecionada = 1;
		String text = "";
		boolean temErro = false;
		JPanel panel = new JPanel();
		JLabel lbl = new JLabel(message + " ");
		JTextField txt = new JTextField(10);
		panel.add(lbl);
		panel.add(txt);
		String[] options = {"OK"};
		
		while(opcaoSelecionada != 0 || text.isEmpty()) {					
			opcaoSelecionada = JOptionPane.showOptionDialog(null, panel, "APP COMIDA", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
		
			if(opcaoSelecionada == 0)
			    text = txt.getText();			
			if((opcaoSelecionada == 0 || text.isEmpty()) && !temErro) {
				panel = MensagemErro(panel, "Informe o campo corretamente");
				temErro = true;
			}
				
		}		
		return text;
	}
	
	public int QuestionInt(String message) {
		var opcaoSelecionada = 1;
		int resultado = 0;
		boolean estaCorreto = false;
		boolean temErro = false;
		String[] options = {"OK"};
		JPanel panel = new JPanel();
		JLabel lbl = new JLabel(message + " ");
		JTextField txt = new JTextField(10);
		panel.add(lbl);
		panel.add(txt);
		
		while(opcaoSelecionada != 0 && !estaCorreto) {			
			opcaoSelecionada = JOptionPane.showOptionDialog(null, panel, "APP COMIDA", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);		
			if(opcaoSelecionada == 0) {
				try {
					var text = txt.getText();
					resultado = Integer.parseInt(text);
					estaCorreto = true;				
				} catch(NumberFormatException e) {
					opcaoSelecionada = 1;
				}
				
				if((opcaoSelecionada == 1 && !estaCorreto) && !temErro) {
					panel = MensagemErro(panel, "Informe um número inteiro");
					temErro = true;
				}
			}
		}	
		return resultado;
	}
	
	public float QuestionFloat(String message) {
		var opcaoSelecionada = 1;
		float resultado = 0;
		boolean estaCorreto = false;
		boolean temErro = false;
		String[] options = {"OK"};
		JPanel panel = new JPanel();
		JLabel lbl = new JLabel(message + " ");
		JTextField txt = new JTextField(10);
		panel.add(lbl);
		panel.add(txt);		
		while(opcaoSelecionada != 0 && !estaCorreto) {	
			opcaoSelecionada = JOptionPane.showOptionDialog(null, panel, "APP COMIDA", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
			if(opcaoSelecionada == 0) {
				try {
					var text = txt.getText();
					resultado = Float.parseFloat(text);
					estaCorreto = true;				
				} catch(NumberFormatException e) {
					opcaoSelecionada = 1;
				}				
				if((opcaoSelecionada == 1 && !estaCorreto) && !temErro) {
					panel = MensagemErro(panel, "Informe um valor numérico");
					temErro = true;
				}
			}
		}	
		return resultado;
	}
	
	public Login login() {
	    JPanel panel = new JPanel(new BorderLayout(5, 5));

	    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
	    label.add(new JLabel("E-Mail", SwingConstants.RIGHT));
	    label.add(new JLabel("Senha", SwingConstants.RIGHT));
	    panel.add(label, BorderLayout.WEST);

	    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
	    JTextField username = new JTextField();
	    controls.add(username);
	    JPasswordField senha = new JPasswordField();
	    controls.add(senha);
	    panel.add(controls, BorderLayout.CENTER);
	    JOptionPane.showMessageDialog(null, panel, "LOGIN", JOptionPane.QUESTION_MESSAGE);
	    
	    var result = new Login();
	    result.Email = username.getText();
	    result.Senha = senha.getText();
	    
	    return result;
	}

	
	
}
