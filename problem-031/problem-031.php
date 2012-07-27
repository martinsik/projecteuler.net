<?php
ini_set('memory_limit', '512M');

//apd_set_pprof_trace(__DIR__);

define("MAX_VAL", 200);
$coins = array(1, 2, 5, 10, 20, 50, 100);
define("MAX_LEN", count($coins));

$maxRange = range(0, count($coins) - 1);

//$called = array();

//$callstack = array(array_fill(0, count($coins), 0));
$callstack = new SplStack();
$callstack->push(array_fill(0, count($coins), 0));

$called = array(
    implode('.', $callstack[0]) => true
);

$hash = null;

$total = 0;
while (!$callstack->isEmpty()) {
    $combination = $callstack->shift();
    //$combination = array_shift($callstack);

    //array_push($called, $combination);
    //$called[implode('.', $combination)] = true;

    $val = 0;
    for ($i=0; $i < MAX_LEN; $i++) {
        $val += $combination[$i] * $coins[$i];
    }

    //var_dump($maxLen, $val);

    if ($val == MAX_VAL) {
        $total++;
    } else {
        for ($i=0; $i < MAX_LEN; $i++) {
            if ($val + $coins[$i] > MAX_VAL) {
                break;
            } else {
                $newList = $combination;
                $newList[$i]++;
                $hash = implode('.', $newList);
                if (!isset($called[$hash])) {
                    //array_push($callstack, $newList);
                    $callstack->push($newList);
                    $called[$hash] = true;
                }
            }
        }
    }
}

echo 'total combinations: ' . ($total + 1) . "\n";
echo 'len(called): ' . count($called) . "\n";
