# Let the Battle Commence

Battle simulator for four fighter types with special scoring rules, prime/square ground effects, and Complex-number monsters. You implement concrete fighters and run against the provided bytecode. **All classes must stay in the default (root) package.**  
_Source of truth: Assignment 1 – Specification._

---

- Implement: `Knight`, `Warrior`, `Paladin`, `DeathEater`.
- You may edit/keep: `util/Complex.java`. `util/TeamMaker.java` is a stub (will be replaced during grading).
- Compile your sources **against** the provided `.class` files, then run `Main`.
- Ground number affects human fighters; Paladin has a Fibonacci override; Death Eater scores from Complex parts.

---

## Project Structure
```
/
└─ Initial Code/
   ├─ class/
   │  ├─ Battle.class
   │  ├─ Combatable.class
   │  ├─ Fighter.class
   │  ├─ Human.class
   │  ├─ Main.class
   │  └─ Monster.class
   ├─ source/
   │  ├─ DeathEater.java
   │  ├─ Knight.java
   │  ├─ Paladin.java
   │  └─ Warrior.java
   └─ util/
      ├─ Complex.java
      ├─ TeamMaker.java
      └─ Utility.java
```

- **Part A (bytecode):** `Combatable`, `Human`, `Fighter`, `Monster`, `Battle`, `Main`  
- **Part B (implement):** `Knight`, `Warrior`, `Paladin`, `DeathEater`  
- **Part C (free-to-change):** keep a `Complex` class; `TeamMaker.java` is placeholder and replaced during tests  
- **No packages** → do **not** add `package` lines.

---

## Gameplay / Scoring (distilled from spec)

### Knight & Warrior (humans)
- **Regular ground:** score depends on `WP` and `baseHP`  
  - If `WP == 1` → `score = baseHP`  
  - Else → `score = baseHP / 10`
- **Prime ground:** **Warrior** gets `score = 2 * baseHP`
- **Perfect-square ground:** **Knight** gets `score = 2 * baseHP`

### Paladin
- Baseline: `score = 3 * baseHP` (may exceed 999).
- **Fibonacci override:** if `baseHP = F_n` with `n > 2`, then `score = 1000 + n`  
  Example: `baseHP = 34 = F9` → `score = 1009`.

### Death Eater (monster)
- Uses MP as a complex number `C = (real, imag)`.
- Score: `|real| + |imag|`.

> Exact APIs and grading setup come from the assignment spec. `TeamMaker` is replaced by the grader; don’t rely on its stub behavior.

---

## Build & Run

> **Windows paths with spaces** (e.g., `Let Battle Commence`): wrap classpaths in quotes.

### Option A — simplest (outputs into existing `class/`)
**Windows (PowerShell/CMD)**
```bash
javac -cp "class" -d "class" source/*.java util/*.java
java  -cp "class" Main
```

**macOS/Linux**
```bash
javac -cp class -d class source/*.java util/*.java
java  -cp class Main
```

### Option B — clean separation (compile to `build/` and keep provided bytecode in `class/`)
**Windows (PowerShell/CMD)**
```bash
mkdir build 2>NUL
javac -cp "class" -d "build" source/*.java util/*.java
java  -cp "class;build" Main
```

**macOS/Linux**
```bash
mkdir -p build
javac -cp class -d build source/*.java util/*.java
java  -cp "class:build" Main
```

---

## Implementation Notes
- **Prime & perfect-square checks:** handle `0`/`1` correctly (`1` is a perfect square; neither is prime).
- **Fibonacci detection:** iterative generation is fine; avoid fragile floating-point checks.
- **Integer division:** `baseHP / 10` is integer division unless your grader specifies otherwise.
- **Complex class:** expose real/imag getters (or equivalent); score is `abs(real) + abs(imag)`.
- **Default package:** keep every class in the root (no `package` statements).

---
