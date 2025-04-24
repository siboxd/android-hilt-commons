# Android Hilt Commons #

This project makes available some common Dagger/[Hilt](https://dagger.dev/hilt/) *Modules* and
relative annotations in order to reuse common set-up regarding `Dispatchers`, *Application* scoped
`CoroutineScope` and `CoroutineExceptionHandler`s.

Here it is the Table of Contents:

<!-- TOC -->
* [Android Hilt Commons](#android-hilt-commons-)
  * [How do I get set up?](#how-do-i-get-set-up-)
  * [Functionalities' overview](#functionalities-overview-)
    * [Artifact `coroutines-module`](#artifact-coroutines-module-)
  * [Contribution guidelines](#contribution-guidelines-)
  * [Contributors](#contributors-)
<!-- TOC -->

## How do I get set up? ##

1. Add this in your root `build.gradle` at the end of repositories:
    ```groovy
    allprojects {
        repositories {
            // ...
            maven { url 'https://jitpack.io' }
        }
    }
    ```

2. Add it to your `build.gradle` with:

    ```groovy
    dependencies {
    
        // Needed to add CoroutineExceptionHandlersModule, DispatchersModule, GlobalCoroutineScopeModule
        implementation("com.github.siboxd.android.hilt.commons:coroutines-module:${latestVersion}")
    }
    ```

## Functionalities' overview ##

Here we will present the contained artifacts and their functionality.

### Artifact `coroutines-module` ###

- `CoroutineExceptionHandlersModule` a module with two types of `CoroutineExceptionHandler`s and
  their annotations.
- `DispatchersModule` a module with the three Android default dispatchers (`Main`,`IO`,`Default`)
  and annotations to inject them.
- `GlobalCoroutineScopeModule` a module with a singleton coroutine scope, useful to inject
  a `CoroutineScope` that has the app process life-span.

## Contribution guidelines ##

1. Create a `feature/**` branch from `develop`
2. Develop your feature, without modifying unrelated things (keep the changes in few parts)
3. Create a Pull Request targeting `develop`, writing a description of changes
4. Wait for a response from the library maintainer

## Contributors ##

* **[Enrico Siboni](https://github.com/siboxd/)** - *Initial work*