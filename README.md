# RecyclerView ItemDecorations [![](https://jitpack.io/v/kibotu/recyclerviewItemDecorations.svg)](https://jitpack.io/#kibotu/recyclerviewItemDecorations)  [![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)
[![Circle CI](https://circleci.com/gh/bleeding182/recyclerviewItemDecorations/tree/master.svg?style=shield)](https://circleci.com/gh/bleeding182/recyclerviewItemDecorations/tree/master)

This project is about showcasing and trying out ItemDecorations for RecyclerViews. There's some blog posts on this topic already [Here](http://bleeding182.blogspot.co.at/2015/11/separator.html) and [Here](http://bleeding182.blogspot.co.at/2015/11/animations-and-decorations.html) covering the basics on how to use decorations.

* Tried adding some CardLayout like Decoration to a RecyclerView.
* Made a lightweight header decoration with shadow and / or parallax effect

![Header Decoration](/readme/headerdecoration.gif)

* Added a decoration for dismissing items to draw in the background like gmail

![Dismissing items](/readme/dismiss.gif)

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