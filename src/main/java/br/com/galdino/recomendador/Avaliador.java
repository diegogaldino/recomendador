package br.com.galdino.recomendador;

import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

public class Avaliador {
	public static void main(String[] args) throws IOException, TasteException {
		
		//Fixa os valores de teste
		RandomUtils.useTestSeed();
		
		DataModel model = new Recomendador().getModeloDeCursos();
		//Avaliador = media da diferença absoluta
		RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		RecommenderBuilder builder = new RecomendadorBuilder();
		//margem de erro
		double erro = evaluator.evaluate(builder, null, model, 0.9, 1.0);
		System.out.println("Para cada recomendação a media de erro para mais ou para menos ficara em torno de: "+erro);
	}
}
