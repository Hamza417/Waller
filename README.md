# Peristyle

Simple wallpaper manager app for Android.

## Why Peristyle?

Peristyle is created to be extremely simple and sophisticated wallpaper manager and browser app
for Android. It solves the problem of having too many features and bloated apps and having
very minimal support for locally stored wallpapers. What if you just wanted an app that allows
you to browse and select your own locally stored wallpapers and lets you manage and set wallpapers
from there? then Peristyle is for you :)

## Features  

#### 🎨 **Effortless Wallpaper Management**  
- Browse, organize, and apply wallpapers seamlessly.  
- Multi-folder support for intuitive categorization.  

#### 🏷️ **Smart Organization Tools**  
- Use custom tags for quick searches and filters.  
- Automatically exclude `.nomedia` directories to keep private collections hidden.  

#### 🎛️ **Dynamic Image Editing**  
- Real-time blur and color adjustments before applying wallpapers.  
- Instant compression and resizing with no quality compromise.  

#### 🚀 **Optimized for Performance**  
- Smooth, elegant animations crafted for speed and responsiveness.  
- Built with a **zero-loading architecture** for instant interactions.  

#### 🔒 **Privacy at Its Core**  
- No ads. No tracking. No analytics.  
- Requires only essential permissions—no internet needed.  

#### 🔄 **Automated Wallpaper Rotation**  
- Auto-change wallpapers with folder or tag-based customization for every screen.  

#### 🖼️ **Live Wallpaper Integration**  
- Effortlessly manage live wallpapers with the built-in selector.  

#### 🌙 **Dark Mode and Adaptive Themes**  
- Full dark mode support for eye comfort.  
- Dynamic **Material You** theming adapts to your device’s palette.  

#### 🌟 **Elegant Glassmorphic Design**  
- Immerse yourself in a stunning interface featuring real-time blurs and caustic shadows.  

#### 🔧 **Developer-Friendly Transparency**  
- Reproducible builds ensure trust and security.

## Stats

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2FHamza417%2FPeri&count_bg=%23292A28&title_bg=%23555555&icon=skyliner.svg&icon_color=%23E7E7E7&title=Visits&edge_flat=false)](https://hits.seeyoufarm.com)
![GitHub all releases](https://img.shields.io/github/downloads/Hamza417/Peri/total?label=Total%20Downloads&color=white)

## Download

[![](https://img.shields.io/github/v/release/Hamza417/Peristyle?color=181717&logo=github&label=GitHub%20Release)](https://github.com/Hamza417/Peristyle/releases/latest)
[![](https://img.shields.io/f-droid/v/app.simple.peri?logo=fdroid&logoColor=white&label=F-Droid&color=1976D2)](https://f-droid.org/en/packages/app.simple.peri/)
[![](https://img.shields.io/endpoint?url=https://apt.izzysoft.de/fdroid/api/v1/shield/app.simple.peri&logo=fdroid)](https://apt.izzysoft.de/fdroid/index/apk/app.simple.peri/)

## Screenshots

| ![01](./fastlane/metadata/android/en-US/images/phoneScreenshots/01.png) | ![02](./fastlane/metadata/android/en-US/images/phoneScreenshots/02.png) | ![03](./fastlane/metadata/android/en-US/images/phoneScreenshots/03.png) |
|:-----------------------------------------------------------------------:|:-----------------------------------------------------------------------:|:-----------------------------------------------------------------------:|
| ![04](./fastlane/metadata/android/en-US/images/phoneScreenshots/04.png) | ![05](./fastlane/metadata/android/en-US/images/phoneScreenshots/05.png) | ![06](./fastlane/metadata/android/en-US/images/phoneScreenshots/06.png) |
| ![07](./fastlane/metadata/android/en-US/images/phoneScreenshots/07.png) | ![08](./fastlane/metadata/android/en-US/images/phoneScreenshots/08.png) | ![09](./fastlane/metadata/android/en-US/images/phoneScreenshots/09.png) |
| ![10](./fastlane/metadata/android/en-US/images/phoneScreenshots/10.png) | ![11](./fastlane/metadata/android/en-US/images/phoneScreenshots/11.png) | ![12](./fastlane/metadata/android/en-US/images/phoneScreenshots/12.png) |

### Peristyle also has a separate UI based on Material You

| ![001](./screenshots/01.png) | ![002](./screenshots/02.png) | ![003](./screenshots/03.png) |
|:----------------------------:|:----------------------------:|:----------------------------:|
| ![004](./screenshots/04.png) | ![005](./screenshots/05.png) | ![006](./screenshots/06.gif) |

## Triggering AutoWallpaperService from Other Apps

Peristyle supports triggering the AutoWallpaperService from other apps using the following
intent: `app.peristyle.START_AUTO_WALLPAPER_SERVICE`

**_You can use any automation or scheduling tool and create your own scenario to change wallpaper for any custom event such as locking/unlocking or as you need._**

## Permission Usage

Peristyle needs `MANAGE_EXTERNAL_STORAGE` and `READ_MEDIA_IMAGES` to be allowed to show the system
wallpapers in the app.
It has been discussed in
the [Issue #72](https://github.com/Hamza417/Peristyle/issues/72#issuecomment-2357558761).

The `REQUEST_IGNORE_BATTERY_OPTIMIZATIONS` is used to run Auto Wallpaper service whenever required.

And an access to all the wallpaper directories whichever the user specifies.

## v5.0.0 and Destructive Changes in the App

Read about it [here](https://github.com/Hamza417/Peristyle/releases/tag/v5.0.0).

## Translate

[![Crowdin](https://badges.crowdin.net/peristyle/localized.svg)](https://crowdin.com/project/peristyle)

Peristyle supports localization, If you want to
translate Peristyle in your language/s, you can do
so [here on Crowdin](https://crowdin.com/project/peristyle).

### Translation Contributors

| Language              | Translators                                                                                                     |
|-----------------------|-----------------------------------------------------------------------------------------------------------------|
| Arabic                | [@eyadmahm0ud](https://crowdin.com/profile/eyadmahm0ud)                                                         |
| Chinese Simplified    | [@shanzhaxiaok](https://crowdin.com/profile/shanzhaxiaok) [@xjchenyang](https://crowdin.com/profile/xjchenyang) |
| Chinese Traditional   | [@aaypkzixad](https://crowdin.com/profile/aaypkzixad), [@hugoalh](https://crowdin.com/profile/hugoalh)          |
| French                | [@ppp987](https://crowdin.com/profile/ppp987)                                                                   |
| German                | [@ottozumkeller](https://crowdin.com/profile/ottozumkeller)                                                     |
| Italian               | [@gabrifrz](https://crowdin.com/profile/gabrifrz)                                                               |
| Polish                | [@Tama10](https://crowdin.com/profile/tama10), [@chefski](https://crowdin.com/profile/chefski)                  |
| Portuguese, Brazilian | [@teogabriel](https://crowdin.com/profile/teogabriel)                                                           |
| Spanish               | [@esneiderfjaimes](https://crowdin.com/profile/esneiderfjaimes)                                                 |
| Turkish               | [@mikropsoft](https://crowdin.com/profile/mikropsoft)                                                           |
| Vietnamese            | [@xeus0000](https://crowdin.com/profile/xeus0000)                                                               |

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
