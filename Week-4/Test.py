# mpi4py test program
from mpi4py import MPI
comm = MPI.COMM_WORLD
rank = comm.Get_rank()
print ("Hello, world! I am process %d of %d." % (rank, comm.Get_size()))

