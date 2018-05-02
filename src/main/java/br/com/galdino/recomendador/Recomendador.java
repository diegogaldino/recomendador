package br.com.galdino.recomendador;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;

public class Recomendador {

	public FileDataModel getModeloDeProdutos() throws IOException {
		return getModelo("dados.csv");
	}
	public FileDataModel getModeloDeCursos() throws IOException {
		return getModelo("cursos.csv");
	}
	private FileDataModel getModelo(String path) throws IOException {
		File file = new File("src/main/resources/"+path);
		FileDataModel model = new FileDataModel(file);
		return model;
	}

}
