package br.com.galdino.recomendador;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.common.RandomUtils;

public class Avaliador {
	public static void main(String[] args) throws IOException, TasteException {
		
		RandomUtils.useTestSeed();
		
		File file = new File("dados.csv");
		FileDataModel model = new FileDataModel(file);
		
		//Avaliador = media da diferença absoluta
		RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		RecommenderBuilder builder = new RecomendadorDeProdutosBuilder();
		//margem de erro
		double erro = evaluator.evaluate(builder, null, model, 0.9, 1.0);
		System.out.println(erro);
	}
}
