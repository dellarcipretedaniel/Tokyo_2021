package Tokyo_2021_Package;

public class FactoryDAO {
	
	public static DeportistaDAO getDeportistaDAO() {
		return new DeportistaDAOjdbc();
	}
	
	public static DisciplinaDAO getDisciplinaDAO() {
		return new DisciplinaDAOjdbc();
	}
	
	public static PaisDAO getPaisDAO() {
		return new PaisDAOjdbc();
	}
	
	public static Deportista_en_disciplinaDAO getDeportista_en_disciplinaDAO() {
		return new Deportista_en_disciplinaDAOjdbc();
	}
	
}
