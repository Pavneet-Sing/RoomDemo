# Note taking app with android Room library

The Room library acts as an abstract layer for underlying SQLite database. 

To get started with room database implementation follow:
 
 [Making a Notes App Using Room Database](https://www.pluralsight.com/guides/making-a-notes-app-using-room-database
) guide published on [**Pluralsight**](https://www.pluralsight.com) 


Note: This project is using [AsyncTask](https://developer.android.com/reference/android/os/AsyncTask) which has been deprecated in Android R(aka Android 11) so follow [room-demo-repo](https://github.com/Pavneet-Sing/room-demo-repo) for udpated codebase.


Introduction
------------
Room is a part of android framework to enhance the database integration with the support of android component to follow the best practices for database oriented apps. Room architecture can be defined as 

![Room Architecture](screenshots/room_architecture.png)

RoomDemo demonstrates the [CRUD](https://en.wikipedia.org/wiki/Create,_read,_update_and_delete) operations to perform:

- Retrieve and display list using recyclerview

![insert and display list](screenshots/insert.gif?raw=true "insert")

- Insert, Update and Delete note records from database

![update and display list](screenshots/update_delete.gif?raw=true "update_delete")


**Note:** Follow [room-demo-repo][1] for best practices as `RoomDemo` is using [AsyncTask][0] which has been deprecated in [API level R][2].

[0]: https://developer.android.com/reference/android/os/AsyncTask
[1]: https://github.com/Pavneet-Sing/room-demo-repo
[2]: https://android-review.googlesource.com/c/platform/frameworks/base/+/1156409/6/core/java/android/os/AsyncTask.java

LICENSE
-------
MIT License

Copyright (c) 2018 Pavneet Singh

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
