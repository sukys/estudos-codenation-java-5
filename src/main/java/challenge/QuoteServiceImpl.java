package challenge;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		return getRamdomQuote(repository.findAll());
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		return getRamdomQuote(repository.findByActor(actor));
	}

	private Quote getRamdomQuote(List<Quote> quotes) {
		int rand = new Random().ints(1, 0, quotes.size()).limit(1).findFirst().getAsInt();
		return quotes.get(rand);
	}
	
}
