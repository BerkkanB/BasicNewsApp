# Simple News App

#  Summary

The application consists of **two pages.** The first page lists the **resources** along with the **category selections.** The second page **lists the news** from the source selected on the first page.

## Techs used

 - Jetpack Compose
 - Compose Navigation
 - Dagger Hilt
 - Room
 - Coil
 - Retrofit
 - okhttp3
 - Coroutines - Flows
 
## Architecture used
 - Mvvm
 - Clean Architecture (with missing strategies, mentioned below)
 - Single Compose Activity

## What could be better ?
Of course, this repo could not be prepared in the best way due to the limited time and lack of motivation. Here are some steps to make this repo more professional;
 - Store api key and base url more appropriate way
 - Usecase could be added to domain layer
 - Multimodule structure could be used
 - Some data mappers and result classes could be implemented to data layers (also error handling)
 - With multimodule structure, Compose Navigation will be implemented better, in accordance with the SOLID principles
 - Categories should be pulled from server
 - Database entities should mapped to ui data form before came to ui layer
 - Unit tests and Portrait mode could be added
 - Slider timer for auto-sliding could be implemented

## Note
The UI-UX never cared
