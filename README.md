## Magiccube-VM

Generic tooling first:

Interactions with NEO blockchain (whatever node infrastructure that requires--0x). Potential

examples are. For the tooling, emulate the process of NEX - the top decentralized exchange on

Neo: 

https://github.com/neonexchange

● NEO based loopback connector

● Setting up a RPC for testing on the NEO testing blockchain

● Magic Cube verified chrome extensions

● Neo node linking

● Direct establishment with all the block producers

Core MCC specific infrastructure:

● IGO contracts

● TCR contracts

● Governance (MIP - Magic Improvement Proposals)

● DEX contracts

● Open-source wallet backend

Specifics

IGO

● Upgrade the existing Cube Kit to Cube Kit 2.0 so that the in-game tokens are NEP5

tokens instead of being centralized.

● Initial auditing of contracts

● Assessing initial audit discoveries

● Execute analysis across multiple IGO models to further improve the models (no smart

contract experience necessary for this step)

● Upgrade Cube Kit 2.0 to Cube Kit 3.0 such that developers only need to fill in select

parameters to IGO. The select parameters would be: token supply count and token

supply rate of distribution, and the behaviors that generate token distribution.

● Re-audit of fixes made re: changes after second phase

● Assess final audit reports from post-fixes

● Launch bug bounty program

###### Deployment hardening, testing, preparation

● Testing

● Live launch



#### IGO Token Supply Curve

Each IGO contract must have a finite token supply.

Each IGO contract must have a supply curve that determines the amount of coins released per

each interaction over the history of those interactions. For example, leveling up today gives you

10 HAWK, but after 1,000,000 level ups, leveling up only gives you 4 HAWK. This curve needs

to be very flexible.

Each IGO contract must specify how many tokens are withheld for the team.

Each IGO contract must be compatible for developers funding in a premine (where some portion

of the coins are distributed before the IGO).

Universal Log-in Standards

We need universal log-in standards so that our user can maintain their identity across our

games and exchanges. That just means linking everything to their identity on the exchange. We

want our users to have a “Magic Cube identity” across all of the games on our platform.

Here is what’s been done on Ethereum for this:

https://github.com/UniversalLogin/UniversalLoginSDK



● Upgrading to Cube Kit to launch smart contracts on the blockchain requires that each

application where tokens are received store a private key for each user. We will have to

work with our games to either create one identity for each user across all of our games

(see ERC 725 and 735 standards for this), or to provide a UI that allows users to link

their exchange accounts with their game accounts, so that even if the public keys are

different, they can have send the funds with just a click. We should probably follow

universal log in standards: 

https://www.youtube.com/watch?v=qF2lhJzngto

.

● Initial auditing of log-in system

● Work with third party to assess initial audit discoveries

● Re-audit of fixes

● Work with another third party to re-assess

● Launch bug bounty program

● Deployment hardening, testing, preparation

● Testing

● Live launch



TCRs (Token Curated Registries)

● Creation of the necessary smart contracts to allow for users to easily apply, vote, and

challenge listings on each MCC token standard’s TCR. Each TCR will likely have include

2 smart contracts: the TCR smart contract and the PLCR smart contract. The TCR

contract is used for access to user funds while the PLCR contract is used for the process

of voting through a commit-reveal scheme.

● Initial auditing of contracts

● Assessing initial audit discoveries.

● Re-audit of fixes made re: changes after first phase

● Assess final audit reports from post-fixes

●Launch bug bounty program

● Deployment hardening, testing, preparation

● Testing

● Live launch

The Set-up of Each TCR

Each Token Curated Registry consists of two contracts, the TCR contract and PLCR Contract.

There are three primary actions to support the functioning of each MCC Token Standard TCR

(The creation and upgrading of MCC Token Standards will be maintained by the Governance

module through the Proxy module.):

Submitting a Candidate

Interaction 1: Users approve that the TCR contract is allowed to transfer their funds from their

wallet.

Interaction 2: Users submit the candidate for application into the registry, which includes the

necessary bond to engage the validators.

Challenging a Candidate

Interaction 1: Users approve that the TCR contract is allowed to transfer their funds from their

wallet.

Interaction 2: Users challenge the candidate’s application into the registry, which includes the

necessary bond to challenge as a validator.

Voting on a Candidate

Interaction 1: Users approve the PLCR contract to transfer funds from their wallet.

Interaction 2: Users requests voting rights from the PLCR contract.

Interaction 3: Users submit their committed vote to the PLCR contract.

Interaction 4: Users submit the reveal hash (for their committed vote) to the PLCR contract





The results of the challenge allow for the updated data of each listing’s status. A challenge can

be performed for any applicant or for any current member of the TCR. All members of the TCR

are required to hold a small stake in the TCR in order to remain listed.

We would like to note some of the beneficial properties of the PLCR contract. The tokens locked

in the PLCR contract to vote are only partially-locked, meaning that they can be used in multiple

polls, so long as the tokens locked are owned by the same address and the polls are executed

by another PLCR contract. The PCLR contract does not punish the voters who vote not in the

majority group. The PLCR contract returns the status of the candidate to the TCR contract to

decide who the winner of the challenge is (in the event of a Pause, the vote is a draw until the

status is changed again), and the loser’s funds are distributed to the challenger and majority

voters appropriately. Votes can be changed during the Pause Period to signal the future result

until an additional challenge is created, at which point validators must lock in their votes to end

the Pause Period.

This set up allows for validators to assuredly and easily vote in multiple polls simultaneously,

while holding accountable the Applicant and Challenger for capturing the network’s time.

Governance

● Similar to the TCR smart contracts, but will require unique smart contracts (likely two:

one to access funds and one to vote or delegate to another voter) to allow for

upgradeability of other smart contracts.

● Will require significant work with ZeppelinOS team

The Governance module provides a backdoor to the Generalized Proxy module for the

governance of all other smart contracts on the MCC platform. The Proxy module acts as a

whitelist for which contracts are valid to be called on the MCC protocol. The Governance

contract contains the following function calls:

Bond — users bond tokens for a buffer period placed both in front of and behind the deadline to

vote; users’ votes will be proportionate to their stakes; users can bond and vote before the

buffer period begins.

Delegate — an account can delegate their stake to another account (the tokens remain bonded

during the delegation period, and therefore cannot be spent during this period).

Vote — an account publishes their vote on a Magic Cube Improvement Proposal.

Abort — an account can abort any participative actions (such as bonding or delegating) before

the buffer period of the vote, if their vote is made before the buffer period. This will be useful if

the account needs to spend MCC for a reason economically more important than the outcome

of the vote to them.

