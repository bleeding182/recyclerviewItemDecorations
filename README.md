# RecyclerView ItemDecorations [![](https://jitpack.io/v/kibotu/recyclerviewItemDecorations.svg)](https://jitpack.io/#kibotu/recyclerviewItemDecorations)  [![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)
[![Circle CI](https://circleci.com/gh/bleeding182/recyclerviewItemDecorations/tree/master.svg?style=shield)](https://circleci.com/gh/bleeding182/recyclerviewItemDecorations/tree/master)

This project showcases some ItemDecorations for RecyclerViews. I wrote blog posts explaining the [basics of drawing decorations](http://blog.davidmedenjak.com/android/2015/11/10/recyclerview-with-decorations-basic-guide.html) and [animating them along with the recyclerview](http://blog.davidmedenjak.com/android/2015/11/18/decorations-animations.html).

## Library

If you find something appealing, please go ahead and just copy it. The MIT license applies. Up to this point I don't see it fit being published as a library. Currently this project is just my personal playground in which I will try out RecyclerView features.

I will not yet be officially releasing any code, because it is not thoroughly tested and I did not yet want to go that extra step.

## Current features

* Made a lightweight header decoration with shadow and / or parallax effect

![Header Decoration](/readme/headerdecoration.gif)

* Added a decoration for dismissing items to draw in the background like Gmail

![Dismissing items](/readme/dismiss.gif)

* Tried adding some CardLayout like Decoration to a RecyclerView.
* Added some Parallax Like effect on a header

![Screenshot](/readme/animation.gif)


How to

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.kibotu:recyclerviewItemDecorations:-SNAPSHOT'
	}