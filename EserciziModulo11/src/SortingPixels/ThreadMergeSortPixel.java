package SortingPixels;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class ThreadMergeSortPixel extends Thread {
	private ArrayList<Color> pixels;
	public ThreadMergeSortPixel(ArrayList<Color> pixels) {
		this.pixels = pixels;
	}

	@Override
	public void run() {
		/*
		int centro = pixels.size() / 2;

		ThreadMergeSortPixel threadSinistra = new ThreadMergeSortPixel(pool, new ArrayList<>(pixels.subList(0, centro)));
		ThreadMergeSortPixel threadDestra = new ThreadMergeSortPixel(pool, new ArrayList<>(pixels.subList(centro, pixels.size())));
		Future<ArrayList<Color>> sinistraF = pool.submit(threadSinistra);
		Future<ArrayList<Color>> destraF = pool.submit(threadDestra);

		ArrayList<Color> sinistra = new ArrayList<>();
		ArrayList<Color> destra =  new ArrayList<>();

		pool.shutdown();
		try {
			pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
			sinistra = sinistraF.get();
			destra = destraF.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return SortingPixels.merge(destra, sinistra);*/
	}
}
