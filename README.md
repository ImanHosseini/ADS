Audio Data Sharing
===================
This is a pre-(pre-alpha) version for a data transmitter using sound. The idea was, to implement a protocol to send and receive any data (an array of bytes, can be a picture, text, etc.) using a speaker and a mic. The basic idea is that by having a sum of sin waves in different frequencies and every frequency acts as a bit (A certain frequency is either SUMMED or it is not-> Corresponding to 1 or 0 value) so by choosing a set interval of frequencies which can be heard by a conventional mics you can send your bytes, and in the receiving end you use FFT to see which frequencies (bits) are on.  
I intend to further "engineer" this system to more efficiency and my theoretical calculations(guesstimates) have lead me to believe this method can achieve as far as 500 KB of bandwidth.

Dependencies: I have used [JTransform](https://github.com/wendykierp/JTransforms) for doing the DFTs.
