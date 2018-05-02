package br.com.galdino.recomendador;

import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

public class RecomendaCursos {
	public static void main(String[] args) throws IOException, TasteException {
		DataModel cursos = new Recomendador().getModeloDeCursos();
		Recommender recommender = new RecomendadorBuilder().buildRecommender(cursos);
		// recomenda para o usuario 1, 3 recomendações
		List<RecommendedItem> recommendations = recommender.recommend(1, 3);
		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
	}
}
