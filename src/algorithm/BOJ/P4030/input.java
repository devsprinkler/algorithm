// 0 < a < b <= 109
// last line must be 0 0

// a < x + 1 < b 인 x 중에서 x가 제곱수 - 1이고 수열 안에 들어가는 수인 경우의 수
// 제곱수 - 1 검증 어떻게?
// sqrt가 정수라면 제곱수...
// sqrt 안쓰고 dt 만들면?
// 3 8 15 24 35 ...

// 3 6 10 15 21 28 36 45 55 66 78 ...
// 3에서 시작해서 +3 +4 +5 ... 오르는 수열

// 두 배열 겹치는 원소만 빼내서 새 배열
// a < x + 1 < b 범위 안에 해당 배열 내 원소 몇개나 들어가는 지 검증
// a - 1 < x < b - 1

//3 15 120 528 4095

//3 * 1, 3 * 5, 3 * 40, 3 * 176, 3 * 1365


// n^2-1
// n(n+1)/2


// 1 109 -> 2