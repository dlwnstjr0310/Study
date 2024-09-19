import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
		List<Info> countList = new ArrayList<>();
		Map<String, Integer> countMap = new HashMap<>();
		Map<String, List<Music>> map = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {

			Music music = new Music(i, genres[i], plays[i]);

			if (map.containsKey(genres[i])) {

				map.get(genres[i]).add(music);

			} else {

				List<Music> musicList = new ArrayList<>();
				musicList.add(music);

				map.put(genres[i], musicList);
			}

			countMap.put(genres[i], countMap.getOrDefault(genres[i], 0) + plays[i]);
		}

		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			countList.add(new Info(entry.getKey(), entry.getValue()));
		}

		countList.sort((o1, o2) -> o2.totalPlayCount - o1.totalPlayCount);

		int size = 0;

		for (Info info : countList) {
			List<Music> musicList = map.get(info.genre);

			musicList.sort(
					(Music o1, Music o2) -> {
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

		for (Info info : countList) {

			List<Music> musicList = map.get(info.genre);
			for (int i = 0; i < musicList.size() && i < 2; i++) {
				answer[index++] = musicList.get(i).index;
			}
		}

		return answer;
    }
    
	/*
	 * 1. 장르 총 재생횟수 순서대로 장르마다 2개씩 ( 총 재생횟수는 모두 다름 )
	 * 2. 장르 내부에서는 곡 별 재생횟수 순서
	 * 3. 재생횟수가 동일하다면 고유번호 순서
	 *  */

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

	public static class Info {

		String genre;

		int totalPlayCount;

		public Info(String genre, int totalPlayCount) {
			this.genre = genre;
			this.totalPlayCount = totalPlayCount;
		}

	}
}