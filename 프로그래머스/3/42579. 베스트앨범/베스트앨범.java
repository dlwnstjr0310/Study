import java.util.*;

class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        
		Map<String, Integer> countMap = new HashMap<>();
		Map<String, List<Music>> map = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {

			Music music = new Music(i, genres[i], plays[i]);

			map.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(music);
			countMap.put(genres[i], countMap.getOrDefault(genres[i], 0) + plays[i]);
		}

		List<String> genreList = new ArrayList<>(countMap.keySet());

		genreList.sort((o1, o2) -> countMap.get(o2) - countMap.get(o1));

		int size = 0;

		for (String genre : genreList) {
			List<Music> musicList = map.get(genre);

			musicList.sort((Music o1, Music o2) -> {
				if (o2.playCount != o1.playCount) {
					return o2.playCount - o1.playCount;
				}
				return o1.index - o2.index;
			});

			if (musicList.size() == 1) {
				size += 1;
			} else {
				size += 2;
			}
		}

		int[] answer = new int[size];
		int index = 0;

		for (String genre : genreList) {

			List<Music> musicList = map.get(genre);
			for (int i = 0; i < musicList.size() && i < 2; i++) {
				answer[index++] = musicList.get(i).index;
			}

		}
		return answer;
    }

	public static class Music {

		int index;

		String genre;

		int playCount;

		public Music(int index, String genre, int playCount) {
			this.index = index;
			this.genre = genre;
			this.playCount = playCount;
		}
	}
}
