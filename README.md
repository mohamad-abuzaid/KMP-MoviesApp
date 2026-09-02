![KMP Movies running across its supported platforms](https://github.com/mohamad-abuzaid/mohamad-abuzaid/assets/935514/5cf70249-eecf-42bb-b483-af7a53ceee9d)

# KMP Movies: a branch-by-branch learning journey

KMP Movies is a guided Kotlin Multiplatform tutorial for developers who want to understand how a shared application grows one engineering decision at a time.

The movie app is the teaching vehicle. The main artifact is the repository history: each numbered branch introduces a focused concern, gives learners a checkpoint they can inspect, and makes the progression from project setup to a network-backed feature visible.

**Targets:** Android, iOS, Web (Wasm), and Desktop.

## Why I built it this way

A completed sample can show *what* was built, but it often hides *how* the pieces came together. I created this repository to make that process teachable for junior developers.

The branch structure reflects how I approach technical mentoring and engineering leadership:

- **Decompose the problem:** move from dependencies and platform setup to architecture, UI, navigation, and data.
- **Introduce concepts in context:** add a tool when the application has a reason to need it.
- **Create reviewable checkpoints:** let a learner compare two branches instead of reverse-engineering a finished codebase.
- **Teach decisions, not recipes:** use each step to ask what belongs in shared code, what remains platform-specific, and what trade-offs the chosen approach creates.
- **Leave room for ownership:** the final app is a foundation for testing, caching, security, and modernization exercises rather than a claim of production completeness.

For portfolio reviewers, this repository demonstrates more than familiarity with KMP libraries. It shows how I organize a broad technical subject into a path that another developer can follow, question, and extend.

## Choose your learning path

The primary path moves from Step 1 to Step 2, then continues with Steps 4–12. Step 3 is a separate Room experiment that also starts from Step 2.

| Step | Branch | Learning checkpoint | Question to explore |
| --- | --- | --- | --- |
| 1 | [`step_1/setup_dependencies`](https://github.com/mohamad-abuzaid/KMP-MoviesApp/tree/step_1/setup_dependencies) | Configure the project targets and shared dependencies. | Which dependencies belong in common code, and which are platform-specific? |
| 2 | [`step_2/setup_koin`](https://github.com/mohamad-abuzaid/KMP-MoviesApp/tree/step_2/setup_koin) | Introduce Koin modules and platform-aware dependency injection. | Where should object creation happen in a multiplatform project? |
| 3 (optional) | [`step_3/setup_room_database`](https://github.com/mohamad-abuzaid/KMP-MoviesApp/tree/step_3/setup_room_database) | Experiment with Room, DAOs, entities, and platform database builders. | What must differ when the same database is opened on Android, iOS, and Desktop? |
| 4 | [`step_4/setup_ktor`](https://github.com/mohamad-abuzaid/KMP-MoviesApp/tree/step_4/setup_ktor) | Build the Ktor networking layer, serialization, models, and mappers. | What can the HTTP client share, and where are platform engines required? |
| 5 | [`step_5/setup_compose`](https://github.com/mohamad-abuzaid/KMP-MoviesApp/tree/step_5/setup_compose) | Establish the shared Compose UI foundation and theme. | Which UI concerns benefit from being shared across every target? |
| 6 | [`step_6/setup_shared_preference`](https://github.com/mohamad-abuzaid/KMP-MoviesApp/tree/step_6/setup_shared_preference) | Persist lightweight settings with Multiplatform Settings. | When is key-value storage enough, and when is a database justified? |
| 7 | [`step_7/setup_localization`](https://github.com/mohamad-abuzaid/KMP-MoviesApp/tree/step_7/setup_localization) | Add shared English and Arabic resources with platform localization hooks. | What belongs in shared resources versus platform locale handling? |
| 8 | [`step_8/setup_navigation`](https://github.com/mohamad-abuzaid/KMP-MoviesApp/tree/step_8/setup_navigation) | Introduce Voyager navigation and screen models. | How should navigation boundaries relate to feature boundaries? |
| 9 | [`step_9/setup_language_select`](https://github.com/mohamad-abuzaid/KMP-MoviesApp/tree/step_9/setup_language_select) | Connect language selection, persistence, and platform behavior. | How does one user choice travel through UI, state, storage, and platform APIs? |
| 10 | [`step_10/setup_home`](https://github.com/mohamad-abuzaid/KMP-MoviesApp/tree/step_10/setup_home) | Build the home experience and reusable movie UI components. | Which components are reusable, and which state belongs at screen level? |
| 11 | [`step_11/setup_movie_details`](https://github.com/mohamad-abuzaid/KMP-MoviesApp/tree/step_11/setup_movie_details) | Add the movie-details experience. | What is the smallest data contract needed to navigate to a detail screen? |
| 12 | [`step_12/implement_popular_api`](https://github.com/mohamad-abuzaid/KMP-MoviesApp/tree/step_12/implement_popular_api) | Connect the popular-movies API to repository, use-case, state, and UI layers. | How should loading, success, transport failure, and image fetching cross the layers? |

> **Why Step 3 is optional:** the Room branch was explored independently and was not merged into Step 4 or the final `main` branch. Follow `1 → 2 → 4 → … → 12` for the complete application path, or `1 → 2 → 3` to study the database experiment.

## How to study the branches

Clone the full repository so that every remote learning checkpoint is available:

```bash
git clone https://github.com/mohamad-abuzaid/KMP-MoviesApp.git
cd KMP-MoviesApp
git branch --remotes
```

Open a checkpoint without creating a local branch:

```bash
git switch --detach origin/step_1/setup_dependencies
```

Compare consecutive checkpoints to see the decision in context:

```bash
git diff --stat \
  origin/step_4/setup_ktor...origin/step_5/setup_compose
```

When you are ready to experiment, create your own branch from the relevant checkpoint:

```bash
git switch --create my-kmp-experiment \
  origin/step_5/setup_compose
```

Do not only ask whether the code runs. Try to explain why the new files belong in their modules, where the platform boundaries are, and which alternative you would choose under different constraints.

## Architecture at the final checkpoint

The final learning checkpoint is divided into four Gradle modules:

| Module | Responsibility |
| --- | --- |
| `composeApp` | Shared Compose UI, presentation state, navigation, resources, and platform entry points. |
| `domain` | Movie models, repository contracts, call-result models, and use cases. |
| `data` | Ktor clients, remote models, mappers, API services, and repository implementations. |
| `di` | Koin modules that assemble services, repositories, use cases, dispatchers, and platform components. |

The project uses `commonMain` for shared behavior and target source sets such as `androidMain`, `iosMain`, `desktopMain`, and `wasmJsMain` where platform implementations are required.

### Main-path technologies

- Kotlin Multiplatform and Compose Multiplatform
- Coroutines and Flow
- Ktor with Kotlinx Serialization
- Koin
- Voyager
- Coil
- Multiplatform Settings by Russhwolf

Room belongs to the optional Step 3 experiment; it is not part of the final `main` branch.

## Run the final application

### Prerequisites

- JDK 17
- Android Studio with an Android SDK for the Android target
- Xcode on macOS for the iOS target
- A [TMDB account and API credentials](https://developer.themoviedb.org/docs/getting-started)

### Configure TMDB

The networking module reads `base_url`, `api`, and `token` from [`config/common.properties`](config/common.properties). The current request path authenticates with the TMDB API Read Access Token stored in `token`.

```properties
base_url=api.themoviedb.org
api=YOUR_TMDB_API_KEY
token=YOUR_TMDB_API_READ_ACCESS_TOKEN
```

This file is tracked as part of the historical tutorial. Use only your own development credentials and do not commit a live secret. A maintained fork should load credentials from an ignored local file or environment variables.

### Run a target

> These are the target entry points defined by the build. The untouched historical dependency set does not currently complete a full Gradle check; see [Known current build limitation](#known-current-build-limitation).

Android:

```bash
./gradlew :composeApp:installDebug
```

Desktop:

```bash
./gradlew :composeApp:run
```

Web (Wasm):

```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

iOS: open `iosApp/iosApp.xcodeproj` in Xcode, select a simulator or device, and run the `iosApp` scheme.

## Engineering notes and next exercises

This repository preserves a learning project created in 2024. Some dependencies were alpha, beta, experimental, or snapshot releases at that time. It is an educational reference, not a current production template, and `main` does not yet include an automated test suite or CI quality gate.

### Known current build limitation

A clean `./gradlew check` currently stops during Wasm dependency resolution, before tests can run. The historical `coil-network-ktor:3.0.0-alpha06` dependency requests `ktor-client-core:2.3.8`, which does not provide the Wasm runtime variant required by this build. Resolving that version alignment is part of modernizing the project, not something this tutorial snapshot hides.

Those constraints make useful follow-on exercises:

1. Add tests for the screen-model state transitions, repository mapping, and network failures.
2. Reconcile the optional Room experiment with the main path and design an offline-first source of truth.
3. Move TMDB credentials out of the tracked configuration file.
4. Upgrade the historical dependency set deliberately, documenting every breaking change instead of changing all versions at once.
5. Add pagination, caching, retry policy, and observability, then explain where each concern belongs.

The goal is not to produce the most polished clone. It is to build enough understanding that you can defend the architecture, diagnose its failures, and improve it with intent.

## Design and data source

- UI reference: [Anime & Movies — Neon Mode on Figma](https://www.figma.com/file/vI6BpWMy3p02hogoFc7R08/App-Anime-%26-Movies-NEON-MODE-(Community))
- Movie data: [The Movie Database API](https://developer.themoviedb.org/reference/intro/getting-started)

## Learn with me

If you are learning Kotlin Multiplatform, open an issue with the branch you are studying, the behavior you expected, what you observed, and the approaches you already tried. That context creates a much better mentoring conversation than a screenshot of an error alone.

If you are reviewing this repository as part of my portfolio, I am happy to discuss why the learning path was structured this way, what I would modernize today, and how I use the same decomposition and review habits when guiding engineering teams.

- [LinkedIn](https://www.linkedin.com/in/mohamad-abuzaid/)
- [Portfolio](https://abuzaid.me/)
