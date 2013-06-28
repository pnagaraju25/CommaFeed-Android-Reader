CommaFeed Reader for Android
============================

## Version 0.1

The official unofficial Android CommaFeed reader is here! It is currently in super-beta mode. It should appear on Google Play in a few hours, until then, feel free to download the APK in the main directory.

Screenshots
-----------

![Login Screen](http://i.imgur.com/IGjNa2al.png) ![Main View](http://i.imgur.com/OEI1OGhl.png) ![Entries View](http://i.imgur.com/Hg8AlHbl.png) ![Entry View](http://i.imgur.com/oobTlKXl.png)

Current Features
----------------

* View unread count
* Browse folders and subscriptions
* View entries in a basic web view
* Get pretty HTTP exceptions

Limitations
-----------

* Does not retain view state very well
* Does literally nothing more than view and refresh
* Depends on the current state (up or down) and latency of CommaFeed itself; it's been shaky on both counts

TODO
----

* Load respective icons from iconURL
* Use ViewState to retain view over onStop() and the like without breaking
* Make web view much much prettier
* Locally mark read entries as, well...read
* Establish an API queue for updating things like read items with the server
* Lots and lots more

Dependencies
------------

* Android Annotations
* Actionbar Sherlock
* Jackson JSON Parser
* Spring for Android core and REST template

## JAR names

Libraries:

* android-support-v4.jar
* androidannotations-api-2.7.1.jar
* jackson-all-1.9.11.jar
* jackson-annotations-2.2.0.jar
* spring-android-auth-1.0.1.RELEASE.jar
* spring-android-core-1.0.1.RELEASE.jar
* spring-android-rest-template-1.0.1.RELEASE.jar

Annotation Processing:

* androidannotations-2.7.1.jar

## Installation Help

[Android Annotations](https://github.com/excilys/androidannotations/wiki/Eclipse-Project-Configuration)

[Actionbar Sherlock](http://actionbarsherlock.com/usage.html)

License
-------

All source code is licensed under the GPL. See the [GPL](http://www.gnu.org/licenses/gpl.html) website for more information.

All code contribution is greatly appreciated!