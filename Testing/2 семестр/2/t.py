from collections import defaultdict
import timeit

def find_max_distance(n, edges):
    graph = defaultdict(list)
    
    for u, v, w in edges:
        graph[u].append((v, w))
        graph[v].append((u, w))

    def dfs(node, parent, distance):
        nonlocal max_distances
        max_distances[node - 1] = max(max_distances[node - 1], distance)

        for neighbor, weight in graph[node]:
            if neighbor != parent:
                dfs(neighbor, node, distance + weight)

    max_distances = [0] * n
    for i in range(1, n + 1):
        dfs(i, 0, 0)

    return max_distances

def main():
    n = int(input())
    
    edges = [list(map(int, input().split())) for _ in range(n - 1)]

    timeit_stmt = "find_max_distance({}, {})".format(n, edges)
    execution_time = timeit.timeit(timeit_stmt, globals=globals(), number=1)

    result = find_max_distance(n, edges)

    for distance in result:
        print(distance)
    
    print("\nВремя выполнения: {:.6f} сек".format(execution_time))

if __name__ == "__main__":
    main()    