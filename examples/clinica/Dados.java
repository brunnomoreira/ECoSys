package clinica;

import java.util.Calendar;

import br.ufrn.imd.dao.DAOException;
import br.ufrn.imd.dao.IDAOEvento;
import br.ufrn.imd.dao.IDAOInscricao;
import br.ufrn.imd.dao.IDAOLocal;
import br.ufrn.imd.dao.IDAOParticipante;
import br.ufrn.imd.model.Evento;
import br.ufrn.imd.model.Inscricao;
import br.ufrn.imd.model.Local;

public class Dados {
	
	public static void cadastrarConsult�rios(IDAOLocal daoConsultorio) {
		Local consultoio1 = new Local("Sala A10", "Rua Santos do Dumont, Pr�dio Salamandra - Segundo Andar");
		Local consultoio2 = new Local("Sala A20", "Rua Santos do Dumont, Pr�dio Salamandra - Segundo Andar");
		Local consultoio3 = new Local("Sala A30", "Rua Santos do Dumont, Pr�dio Salamandra - Segundo Andar");
		
		try {
			daoConsultorio.cadastrar(consultoio1);
			daoConsultorio.cadastrar(consultoio2);
			daoConsultorio.cadastrar(consultoio3);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	public static void cadastrarPacientes(IDAOParticipante daoPaciente) {
		Paciente paciente1 = new Paciente("Rubens Viana Ara�jo", 22, "103.961.714-00", "2.595.811", "8432328845", 3658372549621501L, 1014L);
		Paciente paciente2 = new Paciente("Kau� Rocha Martins", 82, "953.307.474-49", "9.862.578", "8416398442", 3613048989754137L, 1015L);
		Paciente paciente3 = new Paciente("Brenda Oliveira Rodrigues", 57, "933.982.386-96", "2.354.734", "8432228399", 5732972121482467L, 1016L);
		
		try {
			daoPaciente.cadastrar(paciente1);
			daoPaciente.cadastrar(paciente2);
			daoPaciente.cadastrar(paciente3);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	public static void cadastrarMedicos(IDAOParticipante daoMedico) {
		Medico medico1 = new Medico("Nicole Araujo Almeida", "8455555555", "3149-RN", "Clinico Geral");
		Medico medico2 = new Medico("Thiago Santos Correia", "8494358734", "5469-RN", "Cardiologista");
		
		try {
			daoMedico.cadastrar(medico1);
			daoMedico.cadastrar(medico2);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	public static void agendarConsultas(IDAOEvento daoConsulta, IDAOInscricao daoInscricao, IDAOLocal daoConsultorio, IDAOParticipante daoPaciente, IDAOParticipante daoMedico) {
		
		Calendar dataInicio1 = Calendar.getInstance();
		Calendar dataInicio2 = Calendar.getInstance(); 
		Calendar dataInicio3 = Calendar.getInstance(); 
		Calendar dataInicio4 = Calendar.getInstance(); 
		
		dataInicio1.set(2016, Calendar.JULY, 15, 15, 00);
		dataInicio2.set(2016, Calendar.JULY, 19, 14, 40);
		dataInicio3.set(2016, Calendar.SEPTEMBER, 20, 15, 00);
		dataInicio4.set(2016, Calendar.SEPTEMBER, 10, 18, 00);
		
		
		//Agenda uma Consulta com Dr. Nicole e o Paciente Rubens
		Evento consulta1 = new Consulta(
				"Consulta - Dra. Nicole",
				"Consulta com a Dra. Nicole, para realiza��o de exames gerais.",
				daoConsultorio.recuperar(0L),
				dataInicio1
			);
		daoConsulta.cadastrar(consulta1);
		
		Inscricao inscricaoConsulta1Paciente1 = new Inscricao(daoConsulta.recuperar(0), daoPaciente.recuperar(0), TipoInscricao.PACIENTE);
		daoInscricao.cadastrar(inscricaoConsulta1Paciente1);
		Inscricao inscricaoConsulta1Medico1 = new Inscricao(daoConsulta.recuperar(0), daoMedico.recuperar(0), TipoInscricao.MEDICO);
		daoInscricao.cadastrar(inscricaoConsulta1Medico1);
		
		
		//Agenda uma Consulta com Dr. Thiago e o Paciente Rubens
		Evento consulta2 = new Consulta(
				"Consulta - Dr. Thiago",
				"Consulta com a Dr. Thiago, para realiza��o de exame cardi�logico.",
				daoConsultorio.recuperar(1L),
				dataInicio2
			);
		
		daoConsulta.cadastrar(consulta2);
		
		Inscricao inscricaoConsulta2Paciente1 = new Inscricao(daoConsulta.recuperar(1), daoPaciente.recuperar(0), TipoInscricao.PACIENTE);
		daoInscricao.cadastrar(inscricaoConsulta2Paciente1);
		Inscricao inscricaoConsulta2Medico2 = new Inscricao(daoConsulta.recuperar(1), daoMedico.recuperar(1), TipoInscricao.MEDICO);
		daoInscricao.cadastrar(inscricaoConsulta2Medico2);
		
		
		//Agenda uma Consulta com Dr. Thiago e o Paciente Rubens
		Evento consulta3 = new Consulta(
				"Consulta - Dr. Thiago",
				"Inspe��o de Saude de Rotina",
				daoConsultorio.recuperar(2L),
				dataInicio3
			);
		
		daoConsulta.cadastrar(consulta3);
		
		Inscricao inscricaoConsulta3Paciente1 = new Inscricao(daoConsulta.recuperar(2), daoPaciente.recuperar(0), TipoInscricao.PACIENTE);
		daoInscricao.cadastrar(inscricaoConsulta3Paciente1);
		Inscricao inscricaoConsulta3Medico2 = new Inscricao(daoConsulta.recuperar(2), daoMedico.recuperar(1), TipoInscricao.MEDICO);
		daoInscricao.cadastrar(inscricaoConsulta3Medico2);
		
		
		//Agenda uma consulta com Dra. Nicole e o Paciente Kau�
		Evento consulta4 = new Consulta(
				"Consulta - Dra. Nicole",
				"Inspe��o de Saude",
				daoConsultorio.recuperar(0L),
				dataInicio4
			);
		
		daoConsulta.cadastrar(consulta4);
		
		Inscricao inscricaoConsulta4Paciente2 = new Inscricao(daoConsulta.recuperar(3), daoPaciente.recuperar(1), TipoInscricao.PACIENTE);
		daoInscricao.cadastrar(inscricaoConsulta4Paciente2);
		Inscricao inscricaoConsulta4Medico1 = new Inscricao(daoConsulta.recuperar(3), daoMedico.recuperar(0), TipoInscricao.MEDICO);
		daoInscricao.cadastrar(inscricaoConsulta4Medico1);
		
	}
}