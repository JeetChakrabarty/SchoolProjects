public class QuadTree2 {

	//private QueueADT<Region> regionQueue=new LinkedQueue<Region>();
	static QueueADT<Region> regionQueue;

	// Constructor to build quadtree - constructors cannot be recursive
	// but helper methods (i.e. split) can be recursive
	public QuadTree2(MyPicture2 pic,QuadNode node,int maxLevel,
			double mRedT,double mGreenT,double mBlueT,
			double sRedT,double sGreenT,double sBlueT)
	{
		// It is a leaf node
		if(homogeneous(node,sRedT,sGreenT,sBlueT,maxLevel)) 
		{ 
			System.out.println("Homogeneous node - no splitting required"); 
		}
		else 
		{ 
			System.out.println("Not Homogeneous - splitting required"); 
			split(pic,node,maxLevel,sRedT,sGreenT,sBlueT); }
	}

	/**********************************************************/
	// Recursive helper method, split, used to build the tree 
	public void split(MyPicture2 pic,QuadNode node,int maxLevel,
			double sRedT,double sGreenT,double sBlueT){

		double parmNE[] = new double[6];
		double parmNW[] = new double[6];
		double parmSE[] = new double[6];
		double parmSW[] = new double[6];

		parmNE=pic.simpleStatistics(node.getX(),node.getY(),
				node.getSideLength()/2);
		pic.prettyPrintStatistics(node.getX(),node.getY(),
				node.getSideLength()/2,parmNE);
		QuadNode nodeNE = new QuadNode(pic,node.getX(),node.getY(),
				node.getSideLength()/2,
				node.getLevel()+1,parmNE);
		System.out.println("x=" + node.getX() + " y=" + node.getY() + " side=" + node.getSideLength());
		System.out.flush();
		nodeNE.setParent(node);
		if(homogeneous(nodeNE,sRedT,sGreenT,sBlueT,maxLevel)) 
		{ 
			System.out.println("Homogeneous node - no splitting required"); 
		}
		else 
		{ 
			System.out.println("Not Homogeneous - splitting required"); 
			split(pic,nodeNE,maxLevel,sRedT,sGreenT,sBlueT); 
		}

		parmNW=pic.simpleStatistics(node.getX()+node.getSideLength()/2,node.getY(),
				node.getSideLength()/2);
		pic.prettyPrintStatistics(node.getX()+node.getSideLength()/2,node.getY(),
				node.getSideLength()/2,parmNW);
		QuadNode nodeNW = new QuadNode(pic,node.getX()+node.getSideLength()/2,
				node.getY(),node.getSideLength()/2,
				node.getLevel()+1,parmNW);
		System.out.println("x=" + node.getX() + " y=" + node.getY() + " side=" + node.getSideLength());
		System.out.flush();
		nodeNW.setParent(node);
		if(homogeneous(nodeNW,sRedT,sGreenT,sBlueT,maxLevel)) 
		{ 
			System.out.println("Homogeneous - no splitting required"); 
		}
		else 
		{ 
			System.out.println("Not Homogeneous - splitting required"); 
			split(pic,nodeNW,maxLevel,sRedT,sGreenT,sBlueT); 
		}

		parmSE=pic.simpleStatistics(node.getX(),node.getY()+node.getSideLength()/2,
				node.getSideLength()/2);
		pic.prettyPrintStatistics(node.getX(),node.getY()+node.getSideLength()/2,
				node.getSideLength()/2,parmSE);
		QuadNode nodeSE = new QuadNode(pic,node.getX(),node.getY()+node.getSideLength()/2,
				node.getSideLength()/2,node.getLevel()+1,parmSE);
		System.out.println("x=" + node.getX() + " y=" + node.getY() + " side=" + node.getSideLength());
		System.out.flush();
		nodeSE.setParent(node);
		if(homogeneous(nodeSE,sRedT,sGreenT,sBlueT,maxLevel)) 
		{ 
			System.out.println("Homogeneous - no splitting required"); 
		}
		else 
		{ 
			System.out.println("Not Homogeneous - splitting required"); 
			split(pic,nodeSE,maxLevel,sRedT,sGreenT,sBlueT); 
		}

		parmSW=pic.simpleStatistics(node.getX()+node.getSideLength()/2,
				node.getY()+node.getSideLength()/2,
				node.getSideLength()/2);
		pic.prettyPrintStatistics(node.getX()+node.getSideLength()/2,
				node.getY()+node.getSideLength()/2,
				node.getSideLength()/2,parmSW);
		QuadNode nodeSW = new QuadNode(pic,node.getX()+node.getSideLength()/2,
				node.getY()+node.getSideLength()/2,
				node.getSideLength()/2,node.getLevel()+1,parmSW);
		System.out.println("x=" + node.getX() + " y=" + node.getY() + " side=" + node.getSideLength());
		System.out.flush();
		nodeSW.setParent(node);
		if(homogeneous(nodeSW,sRedT,sGreenT,sBlueT,maxLevel)) 
		{ 
			System.out.println("Homogeneous - no splitting required"); 
		}
		else 
		{ 
			System.out.println("Not Homogeneous - splitting required"); 
			split(pic,nodeSW,maxLevel,sRedT,sGreenT,sBlueT); 
		}

		node.setNorthEast(nodeNE);
		node.setNorthWest(nodeNW);
		node.setSouthEast(nodeSE);
		node.setSouthWest(nodeSW);
		nodeNE.setParent(node);
		nodeNW.setParent(node);
		nodeSE.setParent(node);
		nodeSW.setParent(node);
		return;
	}

	/////////////////////////////////////////////////////////
	// Original homogeneous function
	// Is a node homogeneous? Are the red, green and blue standard deviations
	// below red, green and blue thresholds? Is the node level maxLevel (this
	// limits the growth of the tree to have manu small segments)?
	public boolean homogeneous(QuadNode node,
			double sRedT,double sGreenT,double sBlueT,int maxLevel){
		return ((Math.abs(node.getSigmaRed())   <= sRedT) &&
				(Math.abs(node.getSigmaGreen()) <= sGreenT) &&
				(Math.abs(node.getSigmaBlue())  <= sBlueT) || 
				(node.getLevel() >= maxLevel-1));
	}

	/////////////////////////////////////////////////////////
	// First overlaoded homogeneuos function
	// Is a region homogeneous? Are the red, green and blue standard deviations
	// below red, green and blue thresholds? Here we don't care about the level number
	public boolean homogeneous(Region r1,Region r2,
			double mRedT,double mGreenT,double mBlueT,
			double sRedT,double sGreenT,double sBlueT,Boolean PRINT){
		if(PRINT) {
			System.out.println("First overloaded homogeneous function:");
			System.out.println("RGB means for r1: "+r1.getMeanRed()+","+r1.getMeanGreen()+","+r1.getMeanBlue());
			System.out.println("RGB means for r2: "+r2.getMeanRed()+","+r2.getMeanGreen()+","+r2.getMeanBlue());
			System.out.println("RGB sigmas for r1: "+r1.getSigmaRed()+","+r1.getSigmaGreen()+
					","+r1.getSigmaBlue());
			System.out.println("RGB sigmas for r2: "+r2.getSigmaRed()+","+r2.getSigmaGreen()+
					","+r2.getSigmaBlue()); }
		return  ((Math.abs(r1.getSigmaRed())   <= sRedT) &&
				(Math.abs(r1.getSigmaGreen()) <= sGreenT) &&
				(Math.abs(r1.getSigmaBlue())  <= sBlueT) &&
				(Math.abs(r2.getSigmaRed())   <= sRedT) &&
				(Math.abs(r2.getSigmaGreen()) <= sGreenT) &&
				(Math.abs(r2.getSigmaBlue())  <= sBlueT) &&
				(Math.abs(r1.getMeanRed()  - r2.getMeanRed())   <= mRedT) &&
				(Math.abs(r1.getMeanGreen()- r2.getMeanGreen()) <= mGreenT) &&
				(Math.abs(r1.getMeanBlue() - r2.getMeanBlue())  <= mBlueT));
	}

	/////////////////////////////////////////////////////////
	// second overlaoded homogeneuos function
	// Is a region homogeneous? Are the red, green and blue standard deviations
	// below red, green and blue thresholds? Here we don't care about the level number
	public boolean homogeneous(Region r1,Region r2,
			double mRedT,double mGreenT,double mBlueT,
			double sRedT,double sGreenT,double sBlueT,
			Double scaleFactor,Boolean PRINT) {
		if(PRINT) {
			System.out.println("Second overloaded homogeneous function:");
			System.out.println("RGB means for r1: "+r1.getMeanRed()+","+r1.getMeanGreen()+","+r1.getMeanBlue());
			System.out.println("RGB means for r2: "+r2.getMeanRed()+","+r2.getMeanGreen()+","+r2.getMeanBlue());
			System.out.println("RGB sigmas for r1: "+r1.getSigmaRed()+","+r1.getSigmaGreen()+
					","+r1.getSigmaBlue());
			System.out.println("RGB sigmas for r2: "+r2.getSigmaRed()+","+r2.getSigmaGreen()+
					"," +r2.getSigmaBlue());
			System.out.println("scaleFactor=" + scaleFactor); }
		return  ((Math.abs(r1.getSigmaRed())   <= scaleFactor*sRedT) &&
				(Math.abs(r1.getSigmaGreen()) <= scaleFactor*sGreenT) &&
				(Math.abs(r1.getSigmaBlue())  <= scaleFactor*sBlueT) && 
				(Math.abs(r2.getSigmaRed())   <= scaleFactor*sRedT) &&
				(Math.abs(r2.getSigmaGreen()) <= scaleFactor*sGreenT) &&
				(Math.abs(r2.getSigmaBlue())  <= scaleFactor*sBlueT) && 
				(Math.abs(r1.getMeanRed()   - r2.getMeanRed())   <= scaleFactor*mRedT)  &&
				(Math.abs(r1.getMeanGreen() - r2.getMeanGreen()) <= scaleFactor*mGreenT) &&
				(Math.abs(r1.getMeanBlue()  - r2.getMeanBlue())  <= scaleFactor*mBlueT) &&
				(r1.getArea() < scaleFactor*r2.getArea() || 
						r2.getArea() < scaleFactor*r1.getArea()));
	}

	/////////////////////////////////////////////////////////
	// Assignment homogeneous function
	// Is a node homogeneous? Are the red, green and blue standard deviations
	// below red, green and blue thresholds? Is the node level maxLevel (this
	// limits the growth of the tree to have manu small segments)?
	public boolean homogeneous(Region reg,
			double sRedT,double sGreenT,double sBlueT){
		return ((Math.abs(reg.getSigmaRed())   <= sRedT) &&
				(Math.abs(reg.getSigmaGreen()) <= sGreenT) &&
				(Math.abs(reg.getSigmaBlue())  <= sBlueT));
	}
	
	/////////////////////////////////////////////////////////
	// Is a node a leaf node? It must be non-null and have all children nodes being null
	public boolean isLeaf(QuadNode node){
		return (node!=null && node.getNorthEast()==null && node.getNorthWest()==null &&
				node.getSouthEast()==null && node.getSouthWest()==null);
	}

	/////////////////////////////////////////////////////////
	// preorder traverse the QuadTree2: is a leaf node is encountered, we
	// queue it for drawing purposes
	public QueueADT<QuadNode> preOrder(QuadNode node,QueueADT<QuadNode> queue){
		if(node==null) {return queue; }
		if(isLeaf(node)) { queue.enqueue(node); return queue; }
		else
		{
			queue=preOrder(node.getNorthEast(),queue);
			queue=preOrder(node.getNorthWest(),queue);
			queue=preOrder(node.getSouthEast(),queue);
			queue=preOrder(node.getSouthWest(),queue);
			return queue;
		}
	}

	// Old preorder traverse the QuadTree: is a leaf node is encountered, we
	// queue it for drawing purposes
	public QueueADT<QuadNode> preorder(QuadNode node,QueueADT<QuadNode> queue){
		if(isLeaf(node)) { queue.enqueue(node); return queue; }
		else
		{
			queue=preorder(node.getNorthEast(),queue);
			queue=preorder(node.getNorthWest(),queue);
			queue=preorder(node.getSouthEast(),queue);
			queue=preorder(node.getSouthWest(),queue);
			return queue;
		}
	}


	/////////////////////////////////////////////////////////
	// postOrder traverse the QuadTree2: is a leaf node is encountered, we
	// queue it for drawing purposes
	public QueueADT<QuadNode> postOrder(QuadNode node,QueueADT<QuadNode> queue){
		if(node==null) { return queue;}
		else
		{
			queue=postOrder(node.getNorthEast(),queue);
			queue=postOrder(node.getNorthWest(),queue);
			queue=postOrder(node.getSouthEast(),queue);
			queue=postOrder(node.getSouthWest(),queue);
			if(isLeaf(node)) { queue.enqueue(node); return queue;}
			return queue;
		}
	}

	/////////////////////////////////////////////////////////
	// inOrder1 traverse the QuadTree2: is a leaf node is encountered, we
	// queue it for drawing purposes
	public QueueADT<QuadNode> inOrder1(QuadNode node,QueueADT<QuadNode> queue) {
		if(node==null) { return queue; }
		else
		{
			queue=inOrder1(node.getNorthEast(),queue);
			if(isLeaf(node)) { queue.enqueue(node); return queue;}
			queue=inOrder1(node.getNorthWest(),queue);
			queue=inOrder1(node.getSouthEast(),queue);
			queue=inOrder1(node.getSouthWest(),queue);
			return queue;
		}
	}

	/////////////////////////////////////////////////////////
	// inOrder2 traverse the QuadTree2: is a leaf node is encountered, we
	// queue it for drawing purposes
	public QueueADT<QuadNode> inOrder2(QuadNode node,QueueADT<QuadNode> queue){
		if(node==null) { return queue; }
		else
		{
			queue=inOrder1(node.getNorthEast(),queue);
			queue=inOrder1(node.getNorthWest(),queue);
			if(isLeaf(node)) { queue.enqueue(node); return queue; }
			queue=inOrder1(node.getSouthEast(),queue);
			queue=inOrder1(node.getSouthWest(),queue);
			return queue;
		}
	}

	/////////////////////////////////////////////////////////
	// inOrder3 traverse the QuadTree2: is a leaf node is encountered, we
	// queue it for drawing purposes         
	public QueueADT<QuadNode> inOrder3(QuadNode node,QueueADT<QuadNode> queue){
		if(node==null) { return queue; }
		else
		{
			queue=inOrder1(node.getNorthEast(),queue);
			queue=inOrder1(node.getNorthWest(),queue);
			queue=inOrder1(node.getSouthEast(),queue);
			if(isLeaf(node)) { queue.enqueue(node); return queue; }
			queue=inOrder1(node.getSouthWest(),queue);
			return queue;
		}
	}

	/////////////////////////////////////////////////////////
	public QueueADT<Region> treeTraversal(QuadNode root,Integer traversalOrder) {
		QueueADT<QuadNode> queue=new LinkedQueue<QuadNode>();
		QueueADT<Region> regionQueue=new LinkedQueue<Region>();
		System.out.println("traversalOrder=" + traversalOrder);
		if(traversalOrder==1) inOrder1(root,queue);
		else
			if(traversalOrder==2) inOrder2(root,queue);
			else
				if(traversalOrder==3) inOrder3(root,queue);
				else
					if(traversalOrder==4) preOrder(root,queue);
					else
						if(traversalOrder==5) postOrder(root,queue);
		QuadNode q;
		System.out.println("Building regionQueue");
		for(int i=0;i<queue.size();i++)
		{
			q=queue.dequeue();
			queue.enqueue(q);
			System.out.println("Processing quadnode:" + i + " (x,y)=("+ q.getX() + "," + q.getY() + 
					") side=" + q.getSideLength());
			Region region=new Region(q);
			regionQueue.enqueue(region);
		}
		System.out.println("Number of regions:" + regionQueue.size());
		return regionQueue;
	}

	/////////////////////////////////////////////////////////
	public void drawSegmentation(MyPicture2 pic,QueueADT<QuadNode> queue){
		System.out.println("drawSeqmentation queue.size: " + queue.size());
		for(int i=0;i<queue.size();i++)
		{
			QuadNode node=queue.dequeue();
			System.out.println("drawSeqmentation i=" + i + " x=" + (node.getX()) + " y=" + (node.getY()) + " side:" + (node.getSideLength()));
			System.out.flush();
			pic.drawWhiteSquare(node.getX(),node.getY(),node.getSideLength());
			queue.enqueue(node);
		}
	}

	/////////////////////////////////////////////////////////
	// Paint the queued leaf node segments onto the second image as
	// squares of constant color. We use the preserved queue to do this
	// (and indeed, still preserve the queue)
	public void paintSquares(MyPicture2 pic,QueueADT<QuadNode> queue){
		int minSide=512;
		int maxDepth=-1;
		System.out.println("paintSquares queue.size: " + queue.size());
		for(int i=0;i<queue.size();i++)
		{
			QuadNode node=queue.dequeue();
			System.out.println("paintSquares i=" + i + " x=" + (node.getX()) + " y=" + (node.getY()) + " side:" + (node.getSideLength()) + " level=" + node.getLevel());
			System.out.flush();
			if(node.getSideLength() < minSide) minSide=node.getSideLength();
			if(node.getLevel() > maxDepth) maxDepth=node.getLevel();
			pic.paintSegment(node.getX(),node.getY(),node.getSideLength(),
					node.getMeanRed(),node.getMeanGreen(),node.getMeanBlue());
			//pic.drawWhiteSquare(node.getX(),node.getY(),node.getSideLength());
			queue.enqueue(node);
		}
		System.out.println("In paintSquares()");
		System.out.println("MINIMUM SIDE: " + minSide);
		System.out.println("MAXIMUM DEPTH: " + maxDepth);
	}

	/////////////////////////////////////////////////////////
	// Sideways merging 1
	// Test if any 2 regions in the regionQueue should be merged.
	// Test if any of the 2 regions' quodes are adjacent and
	// and the two regions satisy the homogeneuos property 
	// the regions shoud be merged.

	public QueueADT<Region> sidewaysMerge1(QueueADT<Region> regionQueue,
			Double mRedT,Double mGreenT,Double mBlueT,
			Double sRedT,Double sGreenT,Double sBlueT,boolean PRINT) {

		QueueADT<Region> newRegionQueue=new LinkedQueue<Region>();
		QueueADT<Region> regionQueue2=new LinkedQueue<Region>();
		Region r;
		QuadNode q;

		// Check each region against all other regions to see if
		// any should be merged: they must be adjacent and homogenuous.
		// If 2 regions are merged only the new regions in enqueued,
		// with the two mergered regions being discarded. Each merge
		// makes the regionQueue 1 smaller.
		// Merge 2 regions is the same homogeneity critera used
		// to merge square quadtrees is true 
		// Perform this regions until merging can no longer be done.

		// Create a copy of regionQueue in regionQueue2
		for(int i=0;i<regionQueue.size();i++)
		{
			Region r1=regionQueue.dequeue();
			regionQueue.enqueue(r1);
			regionQueue2.enqueue(r1);
		}

		System.out.println("\nInitial number of regions in sideswaysMerge1:"
				+ regionQueue.size() + "\n");

		Boolean performMerge=true;
		while(performMerge)
		{
			performMerge=false;
			restart_loops:
				for(int i=0;i<regionQueue.size();i++)
				{
					Region r1=regionQueue.dequeue();
					regionQueue.enqueue(r1);
					//System.out.println("i loop: regionQueue.size()=" + regionQueue2.size());

					for(int j=0;j<regionQueue2.size();j++)
					{
						//System.out.println("j Loop: regionQueue2.size()=" + regionQueue2.size());
						Region r2=regionQueue2.dequeue();
						regionQueue2.enqueue(r2);

						if(r1!=r2)
						{
							if(r1.adjacent(r2,false) && homogeneous(r1,r2,mRedT,mGreenT,mBlueT,sRedT,sGreenT,sBlueT,false))
							{
								System.out.println("Regions r1=" + i + " and r2=" + j + " are adjacent");
								System.out.println("Regions r1=" + i + " and r2=" + j + " are homogeneous");
								System.out.println("sidewaysMerge1: regions " + i + " and " + j + " merged");
								// delete old r1 and r2 by not putting them in newRegionQueue
								while(!regionQueue.isEmpty())
								{
									r=regionQueue.dequeue();
									if(r!=r1 && r!=r2) newRegionQueue.enqueue(r);
								}
								System.out.println("Region r1 had " + r1.getQuadQueueSize() + " quadnodes");
								System.out.println("Region r2 had " + r2.getQuadQueueSize() + " quadnodes");
								r1.mergeRegion(r2,false);
								performMerge=true;
								System.out.println("Newly merged region r1 has " + r1.getQuadQueueSize() + 
										" quadnodes");
								newRegionQueue.enqueue(r1);
								System.out.println("newRegionQueue.size() after 2 deletions and 1 addition: " 
										+ newRegionQueue.size());
								// At this point old r2, which was merged into r1, is not re-added to queue
								// Now empty the regionQueue and regionQueue2() queues
								while(!regionQueue.isEmpty()) { r=regionQueue.dequeue(); }
								while(!regionQueue2.isEmpty()) { r=regionQueue2.dequeue(); }
								// Empty newRegionQueue and add its regions to regionQueue and regionQueue2
								while(!newRegionQueue.isEmpty())
								{
									r=newRegionQueue.dequeue();
									regionQueue.enqueue(r);
									regionQueue2.enqueue(r);
								}

								System.out.println("regionQueue.size()=" + regionQueue.size());
								System.out.println("regionQueue2.size()=" + regionQueue2.size());
								System.out.println("\nRestarting nested loops\n");
								break restart_loops;
							}
						}
					}
				}
		}
		System.out.println("Number of regions after sideswaysMerge1: "
				+ regionQueue.size());
		return regionQueue;
	} // sidewaysMerge1



	/**Second sidewaysMerge method that merges leaf nodes depending on standard deviations
	 * @param regionQueue queue of regions for the image
	 * @param sRedT standard deviation of the red values
	 * @param sGreenT standard deviation of the green values
	 * @param sBlueT standard deviation of the blue values
	 * @return a new queue of regions
	 */
	public QueueADT<Region> sidewaysMerge2(QueueADT<Region> regionQueue,
			Double sRedT,Double sGreenT,Double sBlueT) {
		
		//Creates 2 regionqueues to return and compare values with
		QueueADT<Region> newRegionQueue=new LinkedQueue<Region>();
		QueueADT<Region> regionQueue2=new LinkedQueue<Region>();
		
		//variables r for the merging of the images, and r3 for the temporary placeholder
		Region r, r3;

		// Check each region against all other regions to see if
		// any should be merged: they must be adjacent and homogenuous.
		// If 2 regions are merged only the new regions in enqueued,
		// with the two mergered regions being discarded. Each merge
		// makes the regionQueue 1 smaller.
		// Merge 2 regions is the same homogeneity critera used
		// to merge square quadtrees is true 
		// Perform this regions until merging can no longer be done.

		// Create a copy of regionQueue in regionQueue2
		for(int i=0;i<regionQueue.size();i++)
		{
			Region r1=regionQueue.dequeue();
			regionQueue.enqueue(r1);
			regionQueue2.enqueue(r1);
		}

		//Prints initial number of regions
		System.out.println("\nInitial number of regions in sideswaysMerge1:"
				+ regionQueue.size() + "\n");

		//Boolean to loop merging procedure
		Boolean performMerge=true;
		
		//While loop that continues until boolean is false
		while(performMerge)
		{
			//Quits loop if break is executed
			performMerge=false;
			
			//Breakpoint
			restart_loops:
				
				//Nested loop to compare every value in both queues
				for(int i=0;i<regionQueue.size();i++)
				{
					//Gets the r1 variable
					Region r1=regionQueue.dequeue();
					regionQueue.enqueue(r1);

					//Loops through second set of queues
					for(int j=0;j<regionQueue2.size();j++)
					{
						//Gets the r2 variable
						Region r2=regionQueue2.dequeue();
						regionQueue2.enqueue(r2);
						
					//Executes if variables are not the same and if regions are adjacent	
					if (r1 != r2 && r1.adjacent(r2, false)) {
						
						//Creates new region and merges regions being compared
						r = new Region();
						r.mergeRegion(r1, false);
						r.mergeRegion(r2, false);
						
						//Executes if newly merged region is homogenous
						if (homogeneous(r, sRedT, sGreenT, sBlueT)) {
							System.out.println("Regions r1=" + i + " and r2=" + j + " are adjacent");
							System.out.println("Regions r1=" + i + " and r2=" + j + " are homogeneous");
							System.out.println("sidewaysMerge1: regions " + i + " and " + j + " merged");
							
							// delete old r1 and r2 by not putting them in newRegionQueue
							while(!regionQueue.isEmpty())
							{
								r3=regionQueue.dequeue();
								if(r3!=r1 && r3!=r2) newRegionQueue.enqueue(r3);
							}
							
							System.out.println("Region r1 had " + r1.getQuadQueueSize() + " quadnodes");
							System.out.println("Region r2 had " + r2.getQuadQueueSize() + " quadnodes");
							performMerge=true;
							System.out.println("Newly merged region r1 has " + r1.getQuadQueueSize() + 
									" quadnodes");
							
							//Adds newly merged region to queu to be returned
							newRegionQueue.enqueue(r);
							
							System.out
									.println("newRegionQueue.size() after 2 deletions and 1 addition: "
											+ newRegionQueue.size());
							
							// At this point old r2, which was merged into r1,
							// is not re-added to queue
							// Now empty the regionQueue and regionQueue2()
							// queues
							while (!regionQueue.isEmpty()) {
								r3 = regionQueue.dequeue();
							}
							while (!regionQueue2.isEmpty()) {
								r3 = regionQueue2.dequeue();
							}
							
							// Empty newRegionQueue and add its regions to
							// regionQueue and regionQueue2
							while (!newRegionQueue.isEmpty()) {
								r3 = newRegionQueue.dequeue();
								regionQueue.enqueue(r3);
								regionQueue2.enqueue(r3);
							}

							System.out.println("regionQueue.size()="
									+ regionQueue.size());
							System.out.println("regionQueue2.size()="
									+ regionQueue2.size());
							System.out.println("\nRestarting nested loops\n");
							
							//Breaks if this point in the code is reached
							break restart_loops;
						}
					}
				}
			}
		}
		
		System.out.println("Number of regions after sideswaysMerge1: "
				+ regionQueue.size());
		
		//Returns queue
		return regionQueue;
	} // sidewaysMerge2

	// ///////////////////////////////////////////////////////
	// preorder traverse the QuadTree2: is a leaf node is encountered, we
	// queue it for drawing purposes
	public QueueADT<QuadNode> order1(QuadNode node, QueueADT<QuadNode> queue) {
		if (node == null) {
			return queue;
		}
		if (isLeaf(node)) {
			queue.enqueue(node);
			visit(node);
			return queue;
		} else {
			queue = order1(node.getNorthEast(), queue);
			queue = order2(node.getNorthWest(), queue);
			queue = order3(node.getSouthEast(), queue);
			queue = order4(node.getSouthWest(), queue);
			return queue;
		}
	}

	// ///////////////////////////////////////////////////////
	// reverse postOrder traverse the QuadTree2: is a leaf node is encountered,
	// we
	// queue it for drawing purposes
	public QueueADT<QuadNode> order2(QuadNode node, QueueADT<QuadNode> queue) {
		if (node == null) {
			return queue;
		} else {
			queue = order2(node.getSouthWest(), queue);
			queue = order2(node.getSouthEast(), queue);
			queue = order2(node.getNorthWest(), queue);
			queue = order2(node.getNorthEast(), queue);
			if (isLeaf(node)) {
				queue.enqueue(node);
				visit(node);
				return queue;
			}
			return queue;
		}
	}

	// ///////////////////////////////////////////////////////
	// Mixed inOrder1 traverse the QuadTree2: is a leaf node is encountered, we
	// queue it for drawing purposes
	public QueueADT<QuadNode> order3(QuadNode node, QueueADT<QuadNode> queue) {
		if (node == null) {
			return queue;
		} else {
			queue = order3(node.getSouthWest(), queue);
			if (isLeaf(node)) {
				queue.enqueue(node);
				visit(node);
				return queue;
			}
			queue = order3(node.getNorthWest(), queue);
			queue = order3(node.getNorthEast(), queue);
			queue = order3(node.getSouthEast(), queue);
			return queue;
		}
	}

	// ///////////////////////////////////////////////////////
	// Mixed inOrder2 traverse the QuadTree2: is a leaf node is encountered, we
	// queue it for drawing purposes
	public QueueADT<QuadNode> order4(QuadNode node, QueueADT<QuadNode> queue) {
		if (node == null) {
			return queue;
		} else {
			queue = order4(node.getNorthEast(), queue);
			queue = order4(node.getSouthEast(), queue);
			if (isLeaf(node)) {
				queue.enqueue(node);
				visit(node);
				return queue;
			}
			queue = order4(node.getNorthWest(), queue);
			queue = order4(node.getSouthWest(), queue);
			return queue;
		}
	}

	// ///////////////////////////////////////////////////////
	// Mixed inOrder3 traverse the QuadTree2: is a leaf node is encountered, we
	// queue it for drawing purposes
	public QueueADT<QuadNode> order5(QuadNode node, QueueADT<QuadNode> queue) {
		if (node == null) {
			return queue;
		} else {
			queue = order5(node.getNorthWest(), queue);
			queue = order5(node.getNorthEast(), queue);
			queue = order5(node.getSouthEast(), queue);
			if (isLeaf(node)) {
				queue.enqueue(node);
				visit(node);
				return queue;
			}
			queue = order5(node.getSouthWest(), queue);
			return queue;
		}
	}

	// ///////////////////////////////////////////////////////
	public QueueADT<Region> treeTraversal2(QuadNode root, Integer traversalOrder) {
		QueueADT<QuadNode> queue = new LinkedQueue<QuadNode>();
		QueueADT<Region> regionQueue = new LinkedQueue<Region>();
		System.out.println("traversalOrder=" + traversalOrder);
		if (traversalOrder == 1)
			order1(root, queue);
		else if (traversalOrder == 2)
			order2(root, queue);
		else if (traversalOrder == 3)
			order3(root, queue);
		else if (traversalOrder == 4)
			order4(root, queue);
		else if (traversalOrder == 5)
			order5(root, queue);
		QuadNode q;
		System.out.println("Building regionQueue");
		for (int i = 0; i < queue.size(); i++) {
			q = queue.dequeue();
			queue.enqueue(q);
			System.out
					.println("Processing quadnode:" + i + " (x,y)=(" + q.getX()
							+ "," + q.getY() + ") side=" + q.getSideLength());
			Region region = new Region(q);
			regionQueue.enqueue(region);
		}
		System.out.println("Number of regions:" + regionQueue.size());
		return regionQueue;
	}

	// /////////////////////////////////////////////////
	// Visit a node by printing out its x,y position,
	// length of side and level in the quadtree
	public void visit(QuadNode node) {
		System.out.println("Visiting (x,y)=(" + node.getX() + "," + node.getY()
				+ ") length=" + node.getSideLength() + "  level="
				+ node.getLevel());
	}

} // QuadTree2
