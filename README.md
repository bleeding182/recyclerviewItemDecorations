# RecyclerView ItemDecorations
[![Circle CI](https://circleci.com/gh/bleeding182/recyclerviewItemDecorations/tree/master.svg?style=shield)](https://circleci.com/gh/bleeding182/recyclerviewItemDecorations/tree/master)

This project showcases some ItemDecorations for RecyclerViews.
There is a blog post about the [basics of drawing decorations][basics] and [animating them along with the recyclerview][animating].

## Library

If you find something appealing, please go ahead and just copy it, the MIT license applies.

I don't see it fit to be published as a library since this would need to include thorough testing and clean interfaces.
So instead this project is just my personal playground in which I will have my go at the `RecyclerView`.

## Current Examples

* A lightweight header decoration with shadow and / or parallax effect

![Header Decoration](/readme/headerdecoration.gif)

* A ViewPagerIndicator Decoration to be used with `SnapHelper`, with [more information here][pagingRVs]

![ViewPagerDecoration](/readme/viewpagerdecoration.gif)

* A decoration for dismissing items to draw in the background like Gmail

![Dismissing items](/readme/dismiss.gif)

* Some CardLayout like Decoration with some Parallax like effect on headers

![Screenshot](/readme/animation.gif)

  [basics]:http://blog.davidmedenjak.com/android/2015/11/10/recyclerview-with-decorations-basic-guide.html
  [animating]:http://blog.davidmedenjak.com/android/2015/11/18/decorations-animations.html
  [pagingRVs]:http://blog.davidmedenjak.com/android/2017/06/24/viewpager-recyclerview.html