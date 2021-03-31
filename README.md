# SIViewPager
The ViewPager with Indicator

## recent version 1.0.1
```
implementation 'com.myhome.siviewpager:siviewpager:1.0.1'
```
> - [example](https://github.com/godsangin/SIViewPagerSample)

## You need to override instantiateItem in your custom adapter that extends SIPagerAdapter
- instantiateItem
> - You need to inflate your pageritem and call addView(pageritem) method
> - You need to call setTag(position) in your instantiateItem method(ensuring onPageSelected method's excution in Viewpager.OnPageChangeListener
> - (+) You need to define orientation in your SIViewPager Tag(in xml)

## version 1.0.0 issue
> ### SIPagerAdapter
> - getItemPosition, destroyItem is not overrided
> - You need to override this method in your custom adapter that extends SIPagerAdapter

> ### AnimationIndicator
> - There is a problem that lose focus if position is 0 in notifyDatasetChangedByPosition method

> ### SIViewPager
> - If you want to use SIViewPager you can use init method to build

## version 1.0.1 issue
> ### SIPagerAdapter
> - getItemPosition, destroyItem are overrided

> ### AnimationIndicator
> - defaultImageResource, selectedIamgeResource are removed
> - losing focus error handling

> ### SIViewPager
> - If you want to use SIViewPager you can use build method to build
