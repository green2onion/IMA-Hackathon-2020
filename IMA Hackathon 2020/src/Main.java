import java.util.*;

public class Main
{
	public static char[][] map;

	public static void initializeMap(int size, int inputCases)
	{
		map = new char[size][size];
		Random random = new Random();
		List<Integer> inputCaseX = new ArrayList();
		List<Integer> inputCaseY = new ArrayList();
		for (int i = 0; i < inputCases; i++)
		{
			inputCaseX.add(random.nextInt(size));
			inputCaseY.add(random.nextInt(size));
		}
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{
				map[i][j] = 'h'; // s is for space
			}
		}

		for (int i = 0; i < inputCases; i++)
		{
			map[inputCaseY.remove(0)][inputCaseX.remove(0)] = 'i'; // i is for infected
		}

	}

	public static void infect()
	{
		char [][] mapNew = new char[map.length][];
		for(int i = 0; i < map.length; i++)
		{
			mapNew[i] = map[i].clone();
		}

		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{
				if (map[i][j] == 'i')
				{
					if (i - 1 >= 0)
					{
						mapNew[i - 1][j] = 'i';
					}
					if (i + 1 < map.length)
					{
						mapNew[i + 1][j] = 'i';
					}
					if (j - 1 >= 0)
					{
						mapNew[i][j - 1] = 'i';
					}
					if (j + 1 < map[i].length)
					{
						mapNew[i][j + 1] = 'i';
					}

				}
			}
		}

		map = mapNew;
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		initializeMap(scanner.nextInt(), scanner.nextInt());
		int iterations = scanner.nextInt();
		for (int n = 0; n < iterations; n++)
		{
			System.out.println("DAY "+(n+1));
			for (int i = 0; i < map.length; i++)
			{
				for (int j = 0; j < map[i].length; j++)
				{
					System.out.print(map[i][j] + " ");
				}

				System.out.println();
			}
			infect();

		}

	}
}
