package com.example.visualsorter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private ListView sortedLV, unsortedLV;
    private ArrayAdapter<String> sortedAA, unsortedAA;
    private int[] sortedNumber, unsortedNumber;
    private String[] sortedString, unsortedString;
    private final int numberOfElements = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.sortedLV = this.findViewById(R.id.sortedLV);
        this.unsortedLV = this.findViewById(R.id.unsortedLV);

        this.sortedNumber = new int[this.numberOfElements];
        this.unsortedNumber = new int[this.numberOfElements];

        this.sortedString = new String[this.numberOfElements];
        this.unsortedString = new String[this.numberOfElements];

        this.sortedAA = new ArrayAdapter<String>(this, R.layout.simple_listview_row,
                this.sortedString);
        this.unsortedAA = new ArrayAdapter<String>(this, R.layout.simple_listview_row,
                this.unsortedString);

        this.sortedLV.setAdapter(this.sortedAA);
        this.unsortedLV.setAdapter(this.unsortedAA);

        this.initializeArray();
    }

    public void insertionSort(int[] ar)
    {
         int theFollower, swap;
         for(int currStart = 1; currStart <ar.length; currStart++)
        {
            theFollower = currStart;
            while(theFollower>0 && ar[theFollower] < ar[theFollower-1])
            {
                swap = ar[theFollower];
                ar[theFollower]=ar[theFollower-1];
                ar[theFollower]=ar[theFollower-1];
                ar[theFollower-1]=swap;
                theFollower--;

            }
        }
    }


    private void mergeSort (int [] ar)
    {

    }




    public void insertionSortButtonPressed (View v)
    {
        //perform an insertion sort on the unsortedArray
        this.insertionSort(this.unsortedNumber);
        this.updateStringArrays();
    }

    public void mergeSortButtonPressed (View v)
    {
        //perform an merge sort on the unsortedArray
        this.mergeSort(this.unsortedNumber);
        this.updateStringArrays();
    }
    public void resetButtonPressed (View v)
    {
        this.initializeArray();
    }

    private void initializeArray()
    {
        //fill my unsorted int Array
        this.fillRandomIntArray(this.unsortedNumber);
        this.copyContentsOfIntArrays(this.unsortedNumber,this.sortedNumber);
        this.updateStringArrays();
    }

    private void updateStringArrays()
    {
        // fill my String arrays to mimic the int arrays
        this.copyIntArrayToStringArray(this.unsortedNumber,this.unsortedString);
        this.copyIntArrayToStringArray(this.sortedNumber, this.sortedString);
        this.sortedAA.notifyDataSetChanged();
        this.unsortedAA.notifyDataSetChanged();
    }

    private void copyIntArrayToStringArray(int[] arInts, String[] arStrings)
    {
        for (int i = 0; i< arInts.length; i++)
        {
            arStrings[i]= "" + arInts[i];
        }
    }

    private void copyContentsOfIntArrays (int[] source, int[] destination)
    {
        for (int i = 0; i < source.length; i++)
        {
            destination[i] = source[i];
        }
    }
    private void fillRandomIntArray (int[] ar)
    {
        Random r = new Random();

        for (int i=0; i <ar.length; i++)
        {
            ar[i]= r.nextInt(500);
        }
    }













}
