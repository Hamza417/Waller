# Peristyle

Simple wallpaper manager app for Android built using Material libraries and design guidelines.

**Update:** Peristyle is going through UI overhaul while migrating towards Compose. You may see a
new and modern looking interface from the newer versions now.

## Why Peristyle?

Peristyle is created to be extremely simple and sophisticated wallpaper manager and browser app
for Android. It solves the problem of having too many features and bloated apps and having
very minimal support for locally stored wallpapers. What if you just wanted an app that allows
you to browse and select your own locally stored wallpapers and lets you manage and set wallpapers
from there? then Peristyle is for you :)

## Features

Features:

- Simple architecture, browse wallpapers and use system wallpaper manager to set them as wallpaper.
- Multiple folders support
- Ability to assign Tags to any wallpaper
- Can scan .nomedia directories, useful if you want to keep your wallpapers away from gallery.
- Apply blur and color filters dynamically on any wallpaper before applying.
- Simple yet pretty animations with proper optimizations
- No ads, no tracking, no analytics, no internet permissions, no unnecessary permissions
- Auto wallpaper change support with dedicated folders and tags for each screens
- Built-in live wallpaper picker
- Dark mode support
- Fully Material You design
- Glassmorphic UI based on realtime blur effects and caustic shadows

## Stats

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2FHamza417%2FPeri&count_bg=%23292A28&title_bg=%23555555&icon=skyliner.svg&icon_color=%23E7E7E7&title=Visits&edge_flat=false)](https://hits.seeyoufarm.com)
![GitHub all releases](https://img.shields.io/github/downloads/Hamza417/Peri/total?label=Total%20Downloads&color=white)
[![Telegram Group](https://img.shields.io/badge/Telegram%20Group-blue?logo=telegram&logoColor=white)](https://t.me/peristyle_app)

## Download

[![](https://img.shields.io/github/v/release/Hamza417/Peristyle?color=181717&logo=github&label=GitHub%20Release)](https://github.com/Hamza417/Peristyle/releases/latest)
[![](https://img.shields.io/f-droid/v/app.simple.peri?logo=fdroid&logoColor=white&label=F-Droid&color=1976D2)](https://f-droid.org/en/packages/app.simple.peri/)
[![](https://img.shields.io/endpoint?url=https://apt.izzysoft.de/fdroid/api/v1/shield/app.simple.peri&logo=fdroid)](https://apt.izzysoft.de/fdroid/index/apk/app.simple.peri/)

## Screenshots

| ![01](./fastlane/metadata/android/en-US/images/phoneScreenshots/01.png) | ![02](./fastlane/metadata/android/en-US/images/phoneScreenshots/02.png) | ![03](./fastlane/metadata/android/en-US/images/phoneScreenshots/03.png) |
|:-----------------------------------------------------------------------:|:-----------------------------------------------------------------------:|:-----------------------------------------------------------------------:|
| ![04](./fastlane/metadata/android/en-US/images/phoneScreenshots/04.png) | ![05](./fastlane/metadata/android/en-US/images/phoneScreenshots/05.png) | ![06](./fastlane/metadata/android/en-US/images/phoneScreenshots/06.png) |
| ![07](./fastlane/metadata/android/en-US/images/phoneScreenshots/07.png) | ![08](./fastlane/metadata/android/en-US/images/phoneScreenshots/08.png) | ![09](./fastlane/metadata/android/en-US/images/phoneScreenshots/09.png) |

### Peristyle also has a totally different UI based on Material You
It can be toggled from the app settings.

| ![001](./screenshots/01.png) | ![002](./screenshots/02.png) | ![003](./screenshots/03.png) |
|:----------------------------:|:----------------------------:|:----------------------------:|
| ![004](./screenshots/04.png) | ![005](./screenshots/05.png) | ![006](./screenshots/06.gif) |

## Triggering AutoWallpaperService from Other Apps

Peristyle supports triggering the AutoWallpaperService from other apps using the following
intent: `app.peristyle.START_AUTO_WALLPAPER_SERVICE`

## Permission Usage
Peristyle needs `MANAGE_EXTERNAL_STORAGE` and `READ_MEDIA_IMAGES` to be allowed to show the system wallpapers in the app.
It has been discussed in the [Issue #72](https://github.com/Hamza417/Peristyle/issues/72#issuecomment-2357558761).

The `REQUEST_IGNORE_BATTERY_OPTIMIZATIONS` is used to run Auto Wallpaper service whenever required.

And an access to all the wallpaper directories whichever the user specifies.

## Translate

[![Crowdin](https://badges.crowdin.net/peristyle/localized.svg)](https://crowdin.com/project/peristyle)

Peristyle supports localization, If you want to
translate Peristyle in your language/s, you can do
so [here on Crowdin](https://crowdin.com/project/peristyle).

### Translation Contributors

| Language              | Translators                                                                                            |
|-----------------------|--------------------------------------------------------------------------------------------------------|
| Arabic                | [@eyadmahm0ud](https://crowdin.com/profile/eyadmahm0ud)                                                |
| Chinese Simplified    | [@shanzhaxiaok](https://crowdin.com/profile/shanzhaxiaok)                                              |
| Chinese Traditional   | [@aaypkzixad](https://crowdin.com/profile/aaypkzixad), [@hugoalh](https://crowdin.com/profile/hugoalh) |
| French                | [@ppp987](https://crowdin.com/profile/ppp987)                                                          |
| Polish                | [@Tama10](https://crowdin.com/profile/tama10)                                                          |
| Portuguese, Brazilian | [@teogabriel](https://crowdin.com/profile/teogabriel)                                                  |
| Spanish               | [@esneiderfjaimes](https://crowdin.com/profile/esneiderfjaimes)                                        |
| Turkish               | [@mikropsoft](https://crowdin.com/profile/mikropsoft)                                                  |
| Vietnamese            | [@xeus0000](https://crowdin.com/profile/xeus0000)                                                      |

Last updated: 18 Sept, 2024

## License

```
Copyright 2023 Hamza Rizwan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
